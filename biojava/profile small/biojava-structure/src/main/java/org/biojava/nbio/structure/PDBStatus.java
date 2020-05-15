/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 */
/**
 */
package org.biojava.nbio.structure;

import org.biojava.nbio.structure.align.util.URLConnectionTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * Methods for getting the status of a PDB file (current, obsolete, etc)
 * and for accessing different versions of the structure.
 *
 * <p>All methods query the
 * <a href="http://www.rcsb.org/pdb/rest/idStatus?structureId=1HHB,3HHB,4HHB">
 * PDB website.</a>
 *
 * <p>PDB supersessions form a directed acyclic graph, where edges point from an
 * obsolete ID to the entry that directly superseded it. For example, here are
 * edges from one portion of the graph:<br/>
 *
 * 1CAT -> 3CAT<br/>
 * 3CAT -> 7CAT<br/>
 * 3CAT -> 8CAT<br/>
 *
 * <p>The methods {@link #getReplaces(String, boolean) getReplaces(pdbId, false)}/
 * {@link #getReplacement(String, boolean, boolean) getReplacement(pdbId, false, true)}
 * just get the incoming/outgoing edges for a single node. The recursive versions
 * ({@link #getReplaces(String, boolean) getReplaces(pdbId, true)},
 * {@link #getReplacement(String, boolean, boolean) getReplacement(pdbId, true, false)})
 * will do a depth-first search up/down the tree and return a list of all nodes ]
 * reached.
 *
 * <p>Finally, the getCurrent() method returns a single PDB ID from among the
 * results of
 * {@link #getReplacement(String, boolean) getReplacement(pdbId, true)}.
 * To be consistent with the old REST ordering, this is the PDB ID that occurs
 * last alphabetically.
 *
 * <p>Results are cached to reduce server load.
 *
 * @author Spencer Bliven <sbliven@ucsd.edu>
 * @author Amr AL-Hossary
 * @since 3.0.2
 */
public class PDBStatus {

    private static final Logger logger = LoggerFactory.getLogger(PDBStatus.class);

    public static final String DEFAULT_PDB_SERVER = "www.rcsb.org";

    public static final String PDB_SERVER_PROPERTY = "PDB.SERVER";

    /**
     *  saves the returned results for further use.
     */
    // TODO Use SoftReferences to allow garbage collection
    private static Map<String, Map<String, String>> recordsCache = new java.util.concurrent.ConcurrentHashMap<String, Map<String, String>>();

    /**
     *  Represents the status of PDB IDs. 'OBSOLETE' and 'CURRENT' are the most
     *  common.
     *  @author Spencer Bliven <sbliven@ucsd.edu>
     */
    public enum Status {

        OBSOLETE,
        CURRENT,
        AUTH,
        HOLD,
        HPUB,
        POLC,
        PROC,
        REFI,
        REPL,
        WAIT,
        WDRN,
        MODEL,
        UNKNOWN;

        /**
         *  @param statusStr
         *  @return
         *  @throws IllegalArgumentException If the string is not recognized
         */
        public static Status fromString(String statusStr) {
            Status status;
            String statusStrUpper = statusStr.toUpperCase();
            if (statusStrUpper.equalsIgnoreCase("OBSOLETE"))
                status = Status.OBSOLETE;
            else if (statusStrUpper.equalsIgnoreCase("CURRENT"))
                status = Status.CURRENT;
            else if (statusStrUpper.equalsIgnoreCase("AUTH"))
                status = Status.AUTH;
            else if (statusStrUpper.equalsIgnoreCase("HOLD"))
                status = Status.HOLD;
            else if (statusStrUpper.equalsIgnoreCase("HPUB"))
                status = Status.HPUB;
            else if (statusStrUpper.equalsIgnoreCase("POLC"))
                status = Status.POLC;
            else if (statusStrUpper.equalsIgnoreCase("PROC"))
                status = Status.PROC;
            else if (statusStrUpper.equalsIgnoreCase("REFI"))
                status = Status.REFI;
            else if (statusStrUpper.equalsIgnoreCase("REPL"))
                status = Status.REPL;
            else if (statusStrUpper.equalsIgnoreCase("WAIT"))
                status = Status.WAIT;
            else if (statusStrUpper.equalsIgnoreCase("WDRN"))
                status = Status.WDRN;
            else if (statusStrUpper.equalsIgnoreCase("MODEL"))
                status = Status.MODEL;
            else if (statusStrUpper.equalsIgnoreCase("UNKNOWN"))
                status = Status.UNKNOWN;
            else {
                throw new IllegalArgumentException("Unable to parse status '" + statusStrUpper + "'.");
            }
            return status;
        }
    }

    /**
     *  Get the status of the PDB in question.
     *
     *  @param pdbId
     *  @return The status, or null if an error occurred.
     */
    public static Status getStatus(String pdbId) {
        Status[] statuses = getStatus(new String[] { pdbId });
        if (statuses != null) {
            assert (statuses.length == 1);
            return statuses[0];
        } else {
            return null;
        }
    }

    /**
     *  Get the status of the a collection of PDBs in question in a single query.
     *
     *  @see #getStatus(String)
     *  @param pdbIds
     *  @return The status array, or null if an error occurred.
     */
    public static Status[] getStatus(String[] pdbIds) {
        Status[] statuses = new Status[pdbIds.length];
        List<Map<String, String>> attrList = getStatusIdRecords(pdbIds);
        // Expect a single record
        if (attrList == null || attrList.size() != pdbIds.length) {
            logger.error("Error getting Status for {} from the PDB website.", Arrays.toString(pdbIds));
            return null;
        }
        for (int pdbNum = 0; pdbNum < pdbIds.length; pdbNum++) {
            // Locate first element of attrList with matching structureId.
            // attrList is usually short, so don't worry about performance
            boolean foundAttr = false;
            for (Map<String, String> attrs : attrList) {
                // Check that the record matches pdbId
                String id = attrs.get("structureId");
                if (id == null || !id.equalsIgnoreCase(pdbIds[pdbNum])) {
                    continue;
                }
                // Check that the status is given
                String statusStr = attrs.get("status");
                Status status = null;
                if (statusStr == null) {
                    logger.error("No status returned for {}", pdbIds[pdbNum]);
                    statuses[pdbNum] = null;
                } else {
                    status = Status.fromString(statusStr);
                }
                if (status == null) {
                    logger.error("Unknown status '{}'", statusStr);
                    statuses[pdbNum] = null;
                }
                statuses[pdbNum] = status;
                foundAttr = true;
            }
            if (!foundAttr) {
                logger.error("No result found for {}", pdbIds[pdbNum]);
                statuses[pdbNum] = null;
            }
        }
        return statuses;
    }

    /**
     *  Gets the current version of a PDB ID. This is equivalent to selecting
     *  the first element from
     *  {@link #getReplacement(String,boolean,boolean)
     *
     *  @param oldPdbId
     *  @return The replacement for oldPdbId, or null if none are found or if an error occurred.
     */
    public static String getCurrent(String oldPdbId) {
        List<String> replacements = getReplacement(oldPdbId, true, false);
        if (replacements != null && !replacements.isEmpty())
            return replacements.get(0);
        else
            return null;
    }

    /**
     *  Gets the PDB which superseded oldPdbId. For CURRENT IDs, this will
     *  be itself. For obsolete IDs, the behavior depends on the recursion
     *  parameter. If false, only IDs which directly supersede oldPdbId are
     *  returned. If true, the replacements for obsolete records are recursively
     *  fetched, yielding a list of all current replacements of oldPdbId.
     *
     *  @param oldPdbId A pdb ID
     *  @param recurse Indicates whether the replacements for obsolete records
     *  		should be fetched.
     *  @param includeObsolete Indicates whether obsolete records should be
     *  		included in the results.
     *  @return The PDB which replaced oldPdbId. This may be oldPdbId itself, for
     *  		current records. A return value of null indicates that the ID has
     *  		been removed from the PDB or that an error has occurred.
     */
    public static List<String> getReplacement(String oldPdbId, boolean recurse, boolean includeObsolete) {
        List<Map<String, String>> attrList = getStatusIdRecords(new String[] { oldPdbId });
        // Expect a single record
        if (attrList == null || attrList.size() != 1) {
            logger.error("Error getting Status for {} from the PDB website.", oldPdbId);
            return null;
        }
        Map<String, String> attrs = attrList.get(0);
        // Check that the record matches pdbId
        String id = attrs.get("structureId");
        if (id == null || !id.equalsIgnoreCase(oldPdbId)) {
            logger.error("Results returned from the query don't match {}", oldPdbId);
            return null;
        }
        // Check that the status is given
        String statusStr = attrs.get("status");
        if (statusStr == null) {
            logger.error("No status returned for {}", oldPdbId);
            return null;
        }
        Status status = Status.fromString(statusStr);
        if (status == null) {
            logger.error("Unknown status '{}'", statusStr);
            return null;
        }
        // If we're current, just return
        LinkedList<String> results = new LinkedList<String>();
        switch(status) {
            case CURRENT:
                results.add(oldPdbId);
                return results;
            case OBSOLETE:
                {
                    String replacementStr = attrs.get("replacedBy");
                    if (replacementStr == null) {
                        logger.error("{} is OBSOLETE but lacks a replacedBy attribute.", oldPdbId);
                        return null;
                    }
                    replacementStr = replacementStr.toUpperCase();
                    // include this result
                    if (includeObsolete) {
                        results.add(oldPdbId);
                    }
                    // Some PDBs are not replaced.
                    if (replacementStr.equals("NONE")) {
                        // empty
                        return results;
                    }
                    String[] replacements = replacementStr.split(" ");
                    Arrays.sort(replacements, new Comparator<String>() {

                        @Override
                        public int compare(String o1, String o2) {
                            return o2.compareToIgnoreCase(o1);
                        }
                    });
                    for (String replacement : replacements) {
                        // Return the replacement.
                        if (recurse) {
                            List<String> others = PDBStatus.getReplacement(replacement, recurse, includeObsolete);
                            mergeReversed(results, others);
                        } else {
                            if (includeObsolete) {
                                mergeReversed(results, Arrays.asList(replacement));
                            } else {
                                // check status of replacement
                                Status replacementStatus = getStatus(replacement);
                                switch(replacementStatus) {
                                    case OBSOLETE:
                                        // ignore obsolete
                                        break;
                                    case CURRENT:
                                    default:
                                        // include it
                                        mergeReversed(results, Arrays.asList(replacement));
                                }
                            }
                        }
                    }
                    return results;
                }
            case UNKNOWN:
                return null;
            default:
                {
                    // TODO handle other cases explicitly. They might have other syntax than "replacedBy"
                    String replacementStr = attrs.get("replacedBy");
                    if (replacementStr == null) {
                        // If no "replacedBy" attribute, treat like we're current
                        // TODO is this correct?
                        results.add(oldPdbId);
                        return results;
                    }
                    replacementStr = replacementStr.toUpperCase();
                    // Some PDBs are not replaced.
                    if (replacementStr.equals("NONE")) {
                        return null;
                    }
                    // include this result, since it's not obsolete
                    results.add(oldPdbId);
                    String[] replacements = replacementStr.split(" ");
                    Arrays.sort(replacements, new Comparator<String>() {

                        @Override
                        public int compare(String o1, String o2) {
                            return o2.compareToIgnoreCase(o1);
                        }
                    });
                    for (String replacement : replacements) {
                        // Return the replacement.
                        if (recurse) {
                            List<String> others = PDBStatus.getReplacement(replacement, recurse, includeObsolete);
                            mergeReversed(results, others);
                        } else {
                            mergeReversed(results, Arrays.asList(replacement));
                        }
                    }
                    return results;
                }
        }
    }

    /**
     *  Takes two reverse sorted lists of strings and merges the second into the
     *  first. Duplicates are removed.
     *
     *  @param merged A reverse sorted list. Modified by this method to contain
     *  		the contents of other.
     *  @param other A reverse sorted list. Not modified.
     */
    private static void mergeReversed(List<String> merged, final List<String> other) {
        if (other.isEmpty())
            return;
        if (merged.isEmpty()) {
            merged.addAll(other);
            return;
        }
        ListIterator<String> m = merged.listIterator();
        ListIterator<String> o = other.listIterator();
        String nextM, prevO;
        prevO = o.next();
        while (m.hasNext()) {
            // peek at m
            nextM = m.next();
            m.previous();
            // insert from O until exhausted or occurs after nextM
            while (prevO.compareTo(nextM) > 0) {
                m.add(prevO);
                if (!o.hasNext()) {
                    return;
                }
                prevO = o.next();
            }
            // remove duplicates
            if (prevO.equals(nextM)) {
                if (!o.hasNext()) {
                    return;
                }
                prevO = o.next();
            }
            m.next();
        }
        m.add(prevO);
        while (o.hasNext()) {
            m.add(o.next());
        }
    }

    /**
     *  Get the ID of the protein which was made obsolete by newPdbId.
     *
     *  @param newPdbId PDB ID of the newer structure
     *  @param recurse If true, return all ancestors of newPdbId.
     *  		Otherwise, just go one step newer than oldPdbId.
     *  @return A (possibly empty) list of ID(s) of the ancestor(s) of
     *  		newPdbId, or <tt>null</tt> if an error occurred.
     */
    public static List<String> getReplaces(String newPdbId, boolean recurse) {
        List<Map<String, String>> attrList = getStatusIdRecords(new String[] { newPdbId });
        // Expect a single record
        if (attrList == null || attrList.size() != 1) {
            // TODO Is it possible to have multiple record per ID?
            // They seem to be combined into one record with space-delimited 'replaces'
            logger.error("Error getting Status for {} from the PDB website.", newPdbId);
            return null;
        }
        Map<String, String> attrs = attrList.get(0);
        // Check that the record matches pdbId
        String id = attrs.get("structureId");
        if (id == null || !id.equals(newPdbId)) {
            logger.error("Results returned from the query don't match {}", newPdbId);
            return null;
        }
        // space-delimited list
        String replacedList = attrs.get("replaces");
        if (replacedList == null) {
            // no replaces value; assume root
            return new ArrayList<String>();
        }
        String[] directDescendents = replacedList.split("\\s");
        // Not the root! Return the replaced PDB.
        if (recurse) {
            // Note: Assumes a proper directed acyclic graph of revisions
            // Cycles will cause infinite loops.
            List<String> allDescendents = new LinkedList<String>();
            for (String replaced : directDescendents) {
                List<String> roots = PDBStatus.getReplaces(replaced, recurse);
                mergeReversed(allDescendents, roots);
            }
            mergeReversed(allDescendents, Arrays.asList(directDescendents));
            return allDescendents;
        } else {
            return Arrays.asList(directDescendents);
        }
    }

    /**
     *  The status of PDB IDs are cached to reduce server overload.
     *
     *  This method clears the cached records.
     */
    public static void clearCache() {
        recordsCache.clear();
    }

    /**
     *  Fetches the status of one or more pdbIDs from the server.
     *
     *  <p>Returns the results as a list of Attributes.
     *  Each attribute should contain "structureId" and "status" attributes, and
     *  possibly more.
     *
     *  <p>Example:</br>
     *  <tt>http://www.rcsb.org/pdb/rest/idStatus?structureID=1HHB,4HHB</tt></br>
     * <pre>&lt;idStatus&gt;
     *   &lt;record structureId="1HHB" status="OBSOLETE" replacedBy="4HHB"/&gt;
     *   &lt;record structureId="4HHB" status="CURRENT" replaces="1HHB"/&gt;
     * &lt;/idStatus&gt;
     *  </pre>
     *
     *  <p>Results are not guaranteed to be returned in the same order as pdbIDs.
     *  Refer to the structureId property to match them.
     *
     *  @param pdbIDs
     *  @return A map between attributes and values
     */
    private static List<Map<String, String>> getStatusIdRecords(String[] pdbIDs) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>(pdbIDs.length);
        String serverName = System.getProperty(PDB_SERVER_PROPERTY);
        if (serverName == null)
            serverName = DEFAULT_PDB_SERVER;
        else
            logger.info(String.format("Got System property %s=%s", PDB_SERVER_PROPERTY, serverName));
        // Build REST query URL
        if (pdbIDs.length < 1) {
            throw new IllegalArgumentException("No pdbIDs specified");
        }
        String urlStr = String.format("http://%s/pdb/rest/idStatus?structureId=", serverName);
        for (String pdbId : pdbIDs) {
            pdbId = pdbId.toUpperCase();
            // check the cache
            if (recordsCache.containsKey(pdbId)) {
                // logger.debug("Fetching "+pdbId+" from Cache");
                result.add(recordsCache.get(pdbId));
            } else {
                urlStr += pdbId + ",";
            }
        }
        // check if any ids still need fetching
        if (urlStr.charAt(urlStr.length() - 1) == '=') {
            return result;
        }
        try {
            logger.info("Fetching {}", urlStr);
            URL url = new URL(urlStr);
            InputStream uStream = url.openStream();
            InputSource source = new InputSource(uStream);
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            PDBStatusXMLHandler handler = new PDBStatusXMLHandler();
            reader.setContentHandler(handler);
            reader.parse(source);
            // Fetch results of SAX parsing
            List<Map<String, String>> records = handler.getRecords();
            // add to cache
            for (Map<String, String> record : records) {
                String pdbId = record.get("structureId").toUpperCase();
                if (pdbId != null) {
                    recordsCache.put(pdbId, record);
                }
            }
            // return results
            result.addAll(handler.getRecords());
        // TODO should throw these forward and let the caller log
        } catch (IOException e) {
            logger.error("Problem getting status for {} from PDB server. Error: {}", Arrays.toString(pdbIDs), e.getMessage());
            return null;
        } catch (SAXException e) {
            logger.error("Problem getting status for {} from PDB server. Error: {}", Arrays.toString(pdbIDs), e.getMessage());
            return null;
        } catch (ParserConfigurationException e) {
            logger.error("Problem getting status for {} from PDB server. Error: {}", Arrays.toString(pdbIDs), e.getMessage());
            return null;
        }
        return result;
    }

    /**
     *  Handles idStatus xml by storing attributes for all record elements.
     *
     *  @author Spencer Bliven <sbliven@ucsd.edu>
     */
    private static class PDBStatusXMLHandler extends DefaultHandler {

        private List<Map<String, String>> records;

        public PDBStatusXMLHandler() {
            records = new org.apache.commons.collections4.list.NodeCachingLinkedList<Map<String, String>>();
        }

        /**
         *  @param uri
         *  @param localName
         *  @param qName
         *  @param attributes
         *  @throws SAXException
         *  @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // System.out.format("Starting element: uri='%s' localName='%s' qName='%s'\n", uri, localName, qName);
            if (qName.equals("record")) {
                // Convert attributes into a Map, as it should have been.
                // Important since SAX reuses Attributes objects for different calls
                Map<String, String> attrMap = new HashMap<String, String>(attributes.getLength() * 2);
                for (int i = 0; i < attributes.getLength(); i++) {
                    attrMap.put(attributes.getQName(i), attributes.getValue(i));
                }
                records.add(attrMap);
            }
        }

        /**
         *  @param e
         *  @throws SAXException
         *  @see org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
         */
        @Override
        public void error(SAXParseException e) throws SAXException {
            logger.error(e.getMessage());
            super.error(e);
        }

        public List<Map<String, String>> getRecords() {
            return records;
        }
    }

    /**
     *  Returns a list of current PDB IDs
     *
     *  @return a list of PDB IDs, or null if a problem occurred
     */
    public static SortedSet<String> getCurrentPDBIds() throws IOException {
        SortedSet<String> allPDBs = new TreeSet<String>();
        String serverName = System.getProperty(PDB_SERVER_PROPERTY);
        if (serverName == null)
            serverName = DEFAULT_PDB_SERVER;
        else
            logger.info(String.format("Got System property %s=%s", PDB_SERVER_PROPERTY, serverName));
        // Build REST query URL
        String urlStr = String.format("http://%s/pdb/rest/getCurrent", serverName);
        URL u = new URL(urlStr);
        InputStream stream = URLConnectionTools.getInputStream(u, 60000);
        if (stream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = null;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf("structureId=");
                if (index > 0) {
                    allPDBs.add(line.substring(index + 13, index + 17));
                }
            }
        }
        return allPDBs;
    }
}
