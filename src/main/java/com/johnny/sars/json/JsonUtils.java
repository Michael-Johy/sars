package com.johnny.sars.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.johnny.sars.lang.exception.Exceptions;

import java.util.Collection;
import java.util.Map;

/**
 * * Created By: yangtao3
 * * Date: 2019/3/5 18:10
 * * Description:Json-util
 */
public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        //not-include Null
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //pretty-json
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        mapper.registerModule(new GuavaModule());
    }

    public static String toJSONString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw Exceptions.uncheckException(e);
        }
    }

    public static String toPrettyJsonString(Object object) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw Exceptions.uncheckException(e);
        }
    }

    public static <T> T parseObject(String str, Class<T> tClass) {
        try {
            return mapper.readValue(str, tClass);
        } catch (Exception e) {
            throw Exceptions.uncheckException(e);
        }
    }

    public static <T> T parseObject(String str, JavaType javaType) {
        try {
            return mapper.readValue(str, javaType);
        } catch (Exception e) {
            throw Exceptions.uncheckException(e);
        }
    }

    public static <T> T parseObject(String str, TypeReference typeReference) {
        try {
            return mapper.readValue(str, typeReference);
        } catch (Exception e) {
            throw Exceptions.uncheckException(e);
        }
    }

    public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    public static JavaType constructParametricType(Class<?> parametrized, JavaType javaType) {
        return mapper.getTypeFactory().constructParametricType(parametrized, javaType);
    }

    public static JavaType constructCollectionType(Class<? extends Collection> collectionClass,
                                                   Class<?> elementClass) {
        return mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    public static JavaType constructCollectionType(Class<? extends Collection> collectionClass,
                                                   JavaType javaType) {
        return mapper.getTypeFactory().constructCollectionType(collectionClass, javaType);
    }

    public static MapType constructMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        return mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

}
