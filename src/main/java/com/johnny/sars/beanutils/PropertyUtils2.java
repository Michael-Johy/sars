package com.johnny.sars.beanutils;

import com.google.common.collect.Lists;
import com.johnny.sars.json.JsonUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * * Created By: yangtao3
 * * Date: 2019/3/20 9:22
 * * Description:封装PropertyUtils
 */
public class PropertyUtils2 {

    public static String getString(Object object, String path) {
        try {
            Object tmp = PropertyUtils.getNestedProperty(object, path);
            if (null == tmp) {
                return null;
            }
            if (tmp instanceof Collection || tmp instanceof Map || tmp instanceof Object[]) {
                return JsonUtils.toJSONString(tmp);
            }
            //Pojo 或 普通对象调用toString()
            return tmp.toString();
        } catch (Exception e) {
            //@todo
        }
        return null;
    }

    public static int getInt(Object object, String path) {
        try {
            Object tmp = PropertyUtils.getNestedProperty(object, path);
            if (null != tmp) {
                return (Integer) tmp;
            }
        } catch (Exception e) {
            //@todo
        }
        return -1;
    }

    public static List getList(Object object, String path) {
        try {
            Object tmp = PropertyUtils.getNestedProperty(object, path);
            if (null != tmp) {
                return (List) tmp;
            }
        } catch (Exception e) {
            //@todo
        }
        return Lists.newArrayList();
    }

}
