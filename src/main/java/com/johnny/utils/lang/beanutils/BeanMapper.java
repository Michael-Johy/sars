package com.johnny.utils.lang.beanutils;

import com.fasterxml.jackson.databind.JavaType;
import com.johnny.utils.json.JsonUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * 实现深度转换Bean<->Bean的Mapper.
 * <p>
 * Created By: yangtao3
 */
public class BeanMapper {

    /**
     * 基于Jackson2将对象A的值拷贝到对象B中.
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        String txt = JsonUtils.toJSONString(source);
        return JsonUtils.parseObject(txt, clazz);
    }

    public static <T> T copy(Object source, JavaType javaType) {
        String txt = JsonUtils.toJSONString(source);
        return JsonUtils.parseObject(txt, javaType);
    }

    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (null == map) {
            return null;
        }
        T obj = clazz.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    public static Map<String, Object> object2Map(Object source, Class<? extends Map<String, Object>> mapClass) throws IllegalAccessException, InstantiationException {
        if (null == source) {
            return null;
        }
        Map<String, Object> result = mapClass.newInstance();
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            int md = field.getModifiers();
            if (Modifier.isStatic(md)) {
                continue;
            }
            field.setAccessible(true);
            result.put(field.getName(), field.get(source));
        }
        return result;
    }
}
