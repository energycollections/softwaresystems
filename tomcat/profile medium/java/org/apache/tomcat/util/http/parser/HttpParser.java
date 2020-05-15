/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.util.http.parser;

import java.io.IOException;
import java.io.Reader;

import org.apache.tomcat.util.res.StringManager;

/**
 * HTTP header value parser implementation. Parsing HTTP headers as per RFC2616
 * is not always as simple as it first appears. For headers that only use tokens
 * the simple approach will normally be sufficient. However, for the other
 * headers, while simple code meets 99.9% of cases, there are often some edge
 * cases that make things far more complicated.
 *
 * The purpose of this parser is to let the parser worry about the edge cases.
 * It provides tolerant (where safe to do so) parsing of HTTP header values
 * assuming that wrapped header lines have already been unwrapped. (The Tomcat
 * header processing code does the unwrapping.)
 *
 */
public class HttpParser {

    private static final int ARRAY_SIZE = 128;

    private static final boolean[] IS_CONTROL = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_SEPARATOR = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_TOKEN = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_HEX = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_NOT_REQUEST_TARGET = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_HTTP_PROTOCOL = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_ALPHA = new boolean[ARRAY_SIZE];
    private static final boolean[] IS_NUMERIC = new boolean[ARRAY_SIZE];

    static {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            // Control> 0-31, 127
            if (i < 32 || i == 127) {
                IS_CONTROL[i] = true;
            }

            // Separator
            if (    i == '(' || i == ')' || i == '<' || i == '>'  || i == '@'  ||
                    i == ',' || i == ';' || i == ':' || i == '\\' || i == '\"' ||
                    i == '/' || i == '[' || i == ']' || i == '?'  || i == '='  ||
                    i == '{' || i == '}' || i == ' ' || i == '\t') {
                IS_SEPARATOR[i] = true;
            }

            // Token: Anything 0-127 that is not a control and not a separator
            if (!IS_CONTROL[i] && !IS_SEPARATOR[i] && i < 128) {
                IS_TOKEN[i] = true;
            }

            // Hex: 0-9, a-f, A-F
            if ((i >= '0' && i <='9') || (i >= 'a' && i <= 'f') || (i >= 'A' && i <= 'F')) {
                IS_HEX[i] = true;
            }

            // Not valid for request target.
            // Combination of multiple rules from RFC7230 and RFC 3986. Must be
            // ASCII, no controls plus a few additional characters excluded
            if (IS_CONTROL[i] || i > 127 ||
                    i == ' ' || i == '\"' || i == '#' || i == '<' || i == '>' || i == '\\' ||
                    i == '^' || i == '`'  || i == '{' || i == '|' || i == '}') {
                IS_NOT_REQUEST_TARGET[i] = true;
            }

            // Not valid for HTTP protocol
            // "HTTP/" DIGIT "." DIGIT
            if (i == 'H' || i == 'T' || i == 'P' || i == '/' || i == '.' || (i >= '0' && i <= '9')) {
                IS_HTTP_PROTOCOL[i] = true;
            }

            if (i >= '0' && i <= '9') {
                IS_NUMERIC[i] = true;
            }

            if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z') {
                IS_ALPHA[i] = true;
            }
        }
    }


    private static final StringManager sm = StringManager.getManager(HttpParser.class);


    public static String unquote(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        int start;
        int end;

        // Skip surrounding quotes if there are any
        if (input.charAt(0) == '"') {
            start = 1;
            end = input.length() - 1;
        } else {
            start = 0;
            end = input.length();
        }

        StringBuilder result = new StringBuilder();
        for (int i = start ; i < end; i++) {
            char c = input.charAt(i);
            if (input.charAt(i) == '\\') {
                i++;
                result.append(input.charAt(i));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


    public static boolean isToken(int c) {
        // Fast for correct values, slower for incorrect ones
        try {
            return IS_TOKEN[c];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }


    public static boolean isHex(int c) {
        // Fast for correct values, slower for some incorrect ones
        try {
            return IS_HEX[c];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }


    public static boolean isNotRequestTarget(int c) {
        // Fast for valid request target characters, slower for some incorrect
        // ones
        try {
            return IS_NOT_REQUEST_TARGET[c];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return true;
        }
    }


    public static boolean isHttpProtocol(int c) {
        // Fast for valid HTTP protocol characters, slower for some incorrect
        // ones
        try {
            return IS_HTTP_PROTOCOL[c];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }


    public static boolean isAlpha(int c) {
        // Fast for valid alpha characters, slower for some incorrect
        // ones
        try {
            return IS_ALPHA[c];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }


    public static boolean isNumeric(int c) {
        // Fast for valid numeric characters, slower for some incorrect
        // ones
        try {
            return IS_NUMERIC[c];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }


    // Skip any LWS and return the next char
    static int skipLws(Reader input, boolean withReset) throws IOException {

        if (withReset) {
            input.mark(1);
        }
        int c = input.read();

        while (c == 32 || c == 9 || c == 10 || c == 13) {
            if (withReset) {
                input.mark(1);
            }
            c = input.read();
        }

        if (withReset) {
            input.reset();
        }
        return c;
    }

    static SkipResult skipConstant(Reader input, String constant) throws IOException {
        int len = constant.length();

        int c = skipLws(input, false);

        for (int i = 0; i < len; i++) {
            if (i == 0 && c == -1) {
                return SkipResult.EOF;
            }
            if (c != constant.charAt(i)) {
                input.skip(-(i + 1));
                return SkipResult.NOT_FOUND;
            }
            if (i != (len - 1)) {
                c = input.read();
            }
        }
        return SkipResult.FOUND;
    }

    /**
     * @return  the token if one was found, the empty string if no data was
     *          available to read or <code>null</code> if data other than a
     *          token was found
     */
    static String readToken(Reader input) throws IOException {
        StringBuilder result = new StringBuilder();

        int c = skipLws(input, false);

        while (c != -1 && isToken(c)) {
            result.append((char) c);
            c = input.read();
        }
        // Skip back so non-token character is available for next read
        input.skip(-1);

        if (c != -1 && result.length() == 0) {
            return null;
        } else {
            return result.toString();
        }
    }

    /**
     * @return the quoted string if one was found, null if data other than a
     *         quoted string was found or null if the end of data was reached
     *         before the quoted string was terminated
     */
    static String readQuotedString(Reader input, boolean returnQuoted) throws IOException {

        int c = skipLws(input, false);

        if (c != '"') {
            return null;
        }

        StringBuilder result = new StringBuilder();
        if (returnQuoted) {
            result.append('\"');
        }
        c = input.read();

        while (c != '"') {
            if (c == -1) {
                return null;
            } else if (c == '\\') {
                c = input.read();
                if (returnQuoted) {
                    result.append('\\');
                }
                result.append(c);
            } else {
                result.append((char) c);
            }
            c = input.read();
        }
        if (returnQuoted) {
            result.append('\"');
        }

        return result.toString();
    }

    static String readTokenOrQuotedString(Reader input, boolean returnQuoted)
            throws IOException {

        // Go back so first non-LWS character is available to be read again
        int c = skipLws(input, true);

        if (c == '"') {
            return readQuotedString(input, returnQuoted);
        } else {
            return readToken(input);
        }
    }

    /**
     * Token can be read unambiguously with or without surrounding quotes so
     * this parsing method for token permits optional surrounding double quotes.
     * This is not defined in any RFC. It is a special case to handle data from
     * buggy clients (known buggy clients for DIGEST auth include Microsoft IE 8
     * &amp; 9, Apple Safari for OSX and iOS) that add quotes to values that
     * should be tokens.
     *
     * @return the token if one was found, null if data other than a token or
     *         quoted token was found or null if the end of data was reached
     *         before a quoted token was terminated
     */
    static String readQuotedToken(Reader input) throws IOException {

        StringBuilder result = new StringBuilder();
        boolean quoted = false;

        int c = skipLws(input, false);

        if (c == '"') {
            quoted = true;
        } else if (c == -1 || !isToken(c)) {
            return null;
        } else {
            result.append((char) c);
        }
        c = input.read();

        while (c != -1 && isToken(c)) {
            result.append((char) c);
            c = input.read();
        }

        if (quoted) {
            if (c != '"') {
                return null;
            }
        } else {
            // Skip back so non-token character is available for next read
            input.skip(-1);
        }

        if (c != -1 && result.length() == 0) {
            return null;
        } else {
            return result.toString();
        }
    }

    /**
     * LHEX can be read unambiguously with or without surrounding quotes so this
     * parsing method for LHEX permits optional surrounding double quotes. Some
     * buggy clients (libwww-perl for DIGEST auth) are known to send quoted LHEX
     * when the specification requires just LHEX.
     *
     * <p>
     * LHEX are, literally, lower-case hexadecimal digits. This implementation
     * allows for upper-case digits as well, converting the returned value to
     * lower-case.
     *
     * @return  the sequence of LHEX (minus any surrounding quotes) if any was
     *          found, or <code>null</code> if data other LHEX was found
     */
    static String readLhex(Reader input) throws IOException {

        StringBuilder result = new StringBuilder();
        boolean quoted = false;

        int c = skipLws(input, false);

        if (c == '"') {
            quoted = true;
        } else if (c == -1 || !isHex(c)) {
            return null;
        } else {
            if ('A' <= c && c <= 'F') {
                c -= ('A' - 'a');
            }
            result.append((char) c);
        }
        c = input.read();

        while (c != -1 && isHex(c)) {
            if ('A' <= c && c <= 'F') {
                c -= ('A' - 'a');
            }
            result.append((char) c);
            c = input.read();
        }

        if (quoted) {
            if (c != '"') {
                return null;
            }
        } else {
            // Skip back so non-hex character is available for next read
            input.skip(-1);
        }

        if (c != -1 && result.length() == 0) {
            return null;
        } else {
            return result.toString();
        }
    }

    static double readWeight(Reader input, char delimiter) throws IOException {
        int c = skipLws(input, false);
        if (c == -1 || c == delimiter) {
            // No q value just whitespace
            return 1;
        } else if (c != 'q') {
            // Malformed. Use quality of zero so it is dropped.
            skipUntil(input, c, delimiter);
            return 0;
        }
        // RFC 7231 does not allow whitespace here but be tolerant
        c = skipLws(input, false);
        if (c != '=') {
            // Malformed. Use quality of zero so it is dropped.
            skipUntil(input, c, delimiter);
            return 0;
        }

        // RFC 7231 does not allow whitespace here but be tolerant
        c = skipLws(input, false);

        // Should be no more than 3 decimal places
        StringBuilder value = new StringBuilder(5);
        int decimalPlacesRead = 0;
        if (c == '0' || c == '1') {
            value.append((char) c);
            c = input.read();
            if (c == '.') {
                value.append('.');
            } else if (c < '0' || c > '9') {
                decimalPlacesRead = 3;
            }
            while (true) {
                c = input.read();
                if (c >= '0' && c <= '9') {
                    if (decimalPlacesRead < 3) {
                        value.append((char) c);
                        decimalPlacesRead++;
                    }
                } else if (c == delimiter || c == 9 || c == 32 || c == -1) {
                    break;
                } else {
                    // Malformed. Use quality of zero so it is dropped and skip until
                    // EOF or the next delimiter
                    skipUntil(input, c, delimiter);
                    return 0;
                }
            }
        } else {
            // Malformed. Use quality of zero so it is dropped and skip until
            // EOF or the next delimiter
            skipUntil(input, c, delimiter);
            return 0;
        }

        double result = Double.parseDouble(value.toString());
        if (result > 1) {
            return 0;
        }
        return result;
    }


    /**
     * @return If inIPv6 is false, the position of ':' that separates the host
     *         from the port or -1 if it is not present. If inIPv6 is true, the
     *         number of characters read
     */
    static int readHostIPv4(Reader reader, boolean inIPv6) throws IOException {
        int octet = -1;
        int octetCount = 1;
        int c;
        int pos = 0;

        do {
            c = reader.read();
            if (c == '.') {
                if (octet > -1 && octet < 256) {
                    // Valid
                    octetCount++;
                    octet = -1;
                } else {
                    throw new IllegalArgumentException(
                            sm.getString("http.invalidOctet", Integer.toString(octet)));
                }
            } else if (isNumeric(c)) {
                if (octet == -1) {
                    octet = c - '0';
                } else {
                    octet = octet * 10 + c - '0';
                }
            } else if (c == ':') {
                break;
            } else if (c == -1) {
                if (inIPv6) {
                    throw new IllegalArgumentException(sm.getString("http.noClosingBracket"));
                } else {
                    pos = -1;
                    break;
                }
            } else if (c == ']') {
                if (inIPv6) {
                    pos++;
                    break;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.closingBracket"));
                }
            } else {
                throw new IllegalArgumentException(sm.getString(
                        "http.illegalCharacterIpv4", Character.toString((char) c)));
            }
            pos++;
        } while (true);

        if (octetCount != 4) {
            throw new IllegalArgumentException(
                    sm.getString("http.wrongOctetCount", Integer.toString(octetCount)));
        }
        if (octet < 0 || octet > 255) {
            throw new IllegalArgumentException(
                    sm.getString("http.invalidOctet", Integer.toString(octet)));
        }

        return pos;
    }


    /**
     * @return The position of ':' that separates the host from the port or -1
     *         if it is not present
     */
    static int readHostIPv6(Reader reader) throws IOException {
        // Must start with '['
        int c = reader.read();
        if (c != '[') {
            throw new IllegalArgumentException(sm.getString("http.noOpeningBracket"));
        }

        int h16Count = 0;
        int h16Size = 0;
        int pos = 1;
        boolean parsedDoubleColon = false;
        int precedingColonsCount = 0;

        do {
            c = reader.read();
            if (h16Count == 0 && precedingColonsCount == 1 && c != ':') {
                // Can't start with a single :
                throw new IllegalArgumentException(sm.getString("http.singleColonStart"));
            }
            if (HttpParser.isHex(c)) {
                if (h16Size == 0) {
                    // Start of a new h16 block
                    precedingColonsCount = 0;
                    h16Count++;
                }
                h16Size++;
                if (h16Size > 4) {
                    throw new IllegalArgumentException(sm.getString("http.invalidHextet"));
                }
            } else if (c == ':') {
                if (precedingColonsCount >=2 ) {
                    // ::: is not allowed
                    throw new IllegalArgumentException(sm.getString("http.tooManyColons"));
                } else {
                    if(precedingColonsCount == 1) {
                        // End of ::
                        if (parsedDoubleColon ) {
                            // Only allowed one :: sequence
                            throw new IllegalArgumentException(
                                    sm.getString("http.tooManyDoubleColons"));
                        }
                        parsedDoubleColon = true;
                        // :: represents at least one h16 block
                        h16Count++;
                    }
                    precedingColonsCount++;
                    // mark if the next symbol is hex before the actual read
                    reader.mark(4);
                }
                h16Size = 0;
            } else if (c == ']') {
                if (precedingColonsCount == 1) {
                    // Can't end on a single ':'
                    throw new IllegalArgumentException(sm.getString("http.singleColonEnd"));
                }
                pos++;
                break;
            } else if (c == '.') {
                if (h16Count == 7 || h16Count < 7 && parsedDoubleColon) {
                    reader.reset();
                    pos -= h16Size;
                    pos += readHostIPv4(reader, true);
                    h16Count++;
                    break;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.invalidIpv4Location"));
                }
            } else {
                throw new IllegalArgumentException(sm.getString(
                        "http.illegalCharacterIpv6", Character.toString((char) c)));
            }
            pos++;
        } while (true);

        if (h16Count > 8) {
            throw new IllegalArgumentException(
                    sm.getString("http.tooManyHextets", Integer.toString(h16Count)));
        } else if (h16Count != 8 && !parsedDoubleColon) {
            throw new IllegalArgumentException(
                    sm.getString("http.tooFewHextets", Integer.toString(h16Count)));
        }

        c = reader.read();
        if (c == ':') {
            return pos;
        } else {
            if(c == -1) {
                return -1;
            }
            throw new IllegalArgumentException(
                    sm.getString("http.illegalAfterIpv6", Character.toString((char) c)));
        }
    }

    /**
     * @return The position of ':' that separates the host from the port or -1
     *         if it is not present
     */
    static int readHostDomainName(Reader reader) throws IOException {
        DomainParseState state = DomainParseState.NEW;
        int pos = 0;

        while (state.mayContinue()) {
            state = state.next(reader.read());
            pos++;
        }

        if (DomainParseState.COLON == state) {
            // State identifies the state of the previous character
            return pos - 1;
        } else {
            return -1;
        }
    }


    /**
     * Skips all characters until EOF or the specified target is found. Normally
     * used to skip invalid input until the next separator.
     */
    static SkipResult skipUntil(Reader input, int c, char target) throws IOException {
        while (c != -1 && c != target) {
            c = input.read();
        }
        if (c == -1) {
            return SkipResult.EOF;
        } else {
            return SkipResult.FOUND;
        }
    }


    private enum DomainParseState {
        NEW(     true, false, false, false, false, false, " at the start of"),
        ALPHA(   true,  true,  true,  true,  true,  true, " after a letter in"),
        NUMERIC( true,  true,  true,  true,  true,  true, " after a number in"),
        PERIOD(  true, false, false, false,  true,  true, " after a period in"),
        HYPHEN(  true,  true,  true, false, false, false, " after a hypen in"),
        COLON(  false, false, false, false, false, false, " after a colon in"),
        END(    false, false, false, false, false, false, " at the end of");

        private final boolean mayContinue;
        private final boolean allowsNumeric;
        private final boolean allowsHyphen;
        private final boolean allowsPeriod;
        private final boolean allowsColon;
        private final boolean allowsEnd;
        private final String errorLocation;

        private DomainParseState(boolean mayContinue, boolean allowsNumeric, boolean allowsHyphen,
                boolean allowsPeriod, boolean allowsColon, boolean allowsEnd, String errorLocation) {
            this.mayContinue = mayContinue;
            this.allowsNumeric = allowsNumeric;
            this.allowsHyphen = allowsHyphen;
            this.allowsPeriod = allowsPeriod;
            this.allowsColon = allowsColon;
            this.allowsEnd = allowsEnd;
            this.errorLocation = errorLocation;
        }

        public boolean mayContinue() {
            return mayContinue;
        }

        public DomainParseState next(int c) {
            if (HttpParser.isAlpha(c)) {
                return ALPHA;
            } else if (HttpParser.isNumeric(c)) {
                if (allowsNumeric) {
                    return NUMERIC;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.invalidCharacterDomain",
                            Character.toString((char) c), errorLocation));
                }
            } else if (c == '.') {
                if (allowsPeriod) {
                    return PERIOD;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.invalidCharacterDomain",
                            Character.toString((char) c), errorLocation));
                }
            } else if (c == ':') {
                if (allowsColon) {
                    return COLON;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.invalidCharacterDomain",
                            Character.toString((char) c), errorLocation));
                }
            } else if (c == -1) {
                if (allowsEnd) {
                    return END;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.invalidCharacterDomain",
                            Character.toString((char) c), errorLocation));
                }
            } else if (c == '-') {
                if (allowsHyphen) {
                    return HYPHEN;
                } else {
                    throw new IllegalArgumentException(sm.getString("http.invalidCharacterDomain",
                            Character.toString((char) c), errorLocation));
                }
            } else {
                throw new IllegalArgumentException(sm.getString(
                        "http.illegalCharacterDomain", Character.toString((char) c)));
            }
        }
    }
}
