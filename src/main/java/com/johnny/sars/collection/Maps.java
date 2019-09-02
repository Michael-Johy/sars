package com.johnny.sars.collection;

import org.apache.commons.collections.MapUtils;

import java.util.Map;

/**
 * * Created By: yangtao3
 * * Date: 2019/8/23 13:41
 * * Description:
 */
public class Maps {

    //-----------------------------------------------------------------------

    /**
     * Null-safe check if the specified map is empty.
     * <p>
     * Null returns true.
     *
     * @param map the map to check, may be null
     * @return true if empty or null
     * @since Commons Collections 3.2
     */
    public static boolean isEmpty(Map map) {
        return (map == null || map.isEmpty());
    }

    /**
     * Null-safe check if the specified map is not empty.
     * <p>
     * Null returns false.
     *
     * @param map the map to check, may be null
     * @return true if non-null and non-empty
     * @since Commons Collections 3.2
     */
    public static boolean isNotEmpty(Map map) {
        return !MapUtils.isEmpty(map);
    }

}
