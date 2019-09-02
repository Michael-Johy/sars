package com.johnny.sars.rule.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description:This CompilerUtils
 * <p>
 * Author: johnny
 * Date  : 2017-11-13 15:22
 */
public final class CompilerUtils {

    private CompilerUtils() {
    }

    private static final Method DEFINE_CLASS_METHOD;

    static {
        try {
            DEFINE_CLASS_METHOD = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
            DEFINE_CLASS_METHOD.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public static Class defineClass(ClassLoader classLoader, String className, byte[] bytes) {
        try {
            return (Class) DEFINE_CLASS_METHOD.invoke(classLoader, className, bytes, 0, bytes.length);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e) {
            throw new AssertionError(e.getCause());
        }
    }


}
