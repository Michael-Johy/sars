package com.johnny.sars.collection;


import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * * Created By: yangtao3
 * * Date: 2019/8/22 18:32
 * * Description:{@link CollectionUtils}
 */
public class Collections {

    public static boolean isEmpty(Collection coll) {
        return null == coll || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

}
