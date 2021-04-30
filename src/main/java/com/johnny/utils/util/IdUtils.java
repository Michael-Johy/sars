package com.johnny.utils.util;

import java.security.SecureRandom;

/**
 * 封装各种生成唯一性ID算法的工具类.
 */
public abstract class IdUtils {

    private static SecureRandom random = new SecureRandom();
    private static UUIDGenerator uuidGenerator = new UUIDGenerator();

    /**
     * 封装Hibernate的UUID
     */
    public static String uuid() {
        return uuidGenerator.generate();
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return random.nextLong();
    }

    public static String randomHex() {
        return Long.toHexString(random.nextLong());
    }
}
