/*
 *                    PDB web development code
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
 *
 * Created on Mar 26, 2009
 * Created by ap3
 *
 */
package org.biojava.nbio.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.*;

public class SoftHashMap<K, V> extends AbstractMap<K, V> {

    private final static Logger logger = LoggerFactory.getLogger(SoftHashMap.class);

    public static final int DEFAULT_LIMIT = 1;

    /**
     * The internal HashMap that stores SoftReference to actual data.
     */
    private final Map<K, SoftReference<V>> map = new org.apache.commons.collections4.map.HashedMap<K, SoftReference<V>>();

    /**
     * Maximum Number of references you dont want GC to collect.
     */
    private final int max_limit;

    /**
     * The FIFO list of hard references, order of last access.
     */
    private final LinkedList<V> hardCache = new LinkedList<V>();

    /**
     * Reference queue for cleared SoftReference objects.
     */
    private final ReferenceQueue<V> queue = new ReferenceQueue<V>();

    public SoftHashMap() {
        this(1000);
    }

    public SoftHashMap(int hardSize) {
        max_limit = hardSize;
    }

    @Override
    public V get(Object key) {
        V result = null;
        // We get the SoftReference represented by that key
        SoftReference<V> soft_ref = map.get(key);
        if (soft_ref != null) {
            try {
                // From the SoftReference we get the value, which can be
                // null if it was not in the map, or it was removed in
                // the clearGCCollected() method defined below
                result = soft_ref.get();
                if (result == null) {
                    // If the value has been garbage collected, remove the
                    // entry from the HashMap.
                    map.remove(key);
                } else {
                    synchronized (hardCache) {
                        hardCache.addFirst(result);
                        if (hardCache.size() > max_limit) {
                            // Remove the last entry if list greater than MAX_LIMIT
                            hardCache.removeLast();
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Exception: ", e);
            }
        }
        return result;
    }

    private static class SoftValue<K, V> extends SoftReference<V> {

        // always make data member final
        private final Object key;

        private SoftValue(V k, K key, ReferenceQueue<? super V> q) {
            super(k, q);
            this.key = key;
        }
    }

    /**
     *  Here we go through the ReferenceQueue and remove garbage collected
     *
     *  SoftValue objects from the HashMap by looking them up using the
     *
     *  SoftValue.key data member.
     */
    // every Reference in queue is stored as a SoftValue
    @SuppressWarnings("unchecked")
    private void clearGCCollected() {
        SoftValue<K, V> sv;
        while ((sv = (SoftValue<K, V>) queue.poll()) != null) {
            // we can access private data!
            map.remove(sv.key);
        }
    }

    /**
     *  Here we put the key, value pair into the HashMap using a SoftValue
     *
     *  object.
     */
    @Override
    public synchronized V put(K key, V value) {
        clearGCCollected();
        logger.debug("Putting {} on cache. size: {}", key, size());
        map.put(key, new SoftValue<K, V>(value, key, queue));
        return value;
    }

    @Override
    public V remove(Object key) {
        clearGCCollected();
        logger.debug("Removing {} from cache. size: {}", key, size());
        return map.remove(key).get();
    }

    @Override
    public void clear() {
        synchronized (hardCache) {
            hardCache.clear();
        }
        clearGCCollected();
        logger.debug("clearing cache");
        map.clear();
    }

    @Override
    public int size() {
        clearGCCollected();
        return map.size();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
