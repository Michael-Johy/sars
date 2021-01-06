package com.johnny.sars.string;

import java.util.Iterator;

/**
 *
 */
public class Strings {

    public static final String EMPTY = "";

    /**
     * <p>Checks if a CharSequence is empty (""), null or whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace only
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * <p>Checks if a CharSequence is not empty (""), not null and not whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is
     * not empty and not null and not whitespace only
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static String join(Object[] elements, String separator) {
        if (null == elements || elements.length == 0) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder(elements.length * 16);
        for (int startIndex = 0; startIndex < elements.length; startIndex++) {
            sb.append(elements[startIndex]);
            if (startIndex != elements.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public static String join(Iterable<?> elements, String seperator) {
        if (null == elements) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> iterator = elements.iterator();
        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        while (iterator.hasNext()) {
            sb.append(seperator);
            sb.append(iterator.next());
        }
        return sb.toString();
    }

}
