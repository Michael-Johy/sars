package com.johnny.middleware.netty.util;

import java.util.concurrent.atomic.AtomicLong;

public class MessageIDUtils {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    public static long nextID() {
        return ID_GENERATOR.getAndIncrement();
    }

}
