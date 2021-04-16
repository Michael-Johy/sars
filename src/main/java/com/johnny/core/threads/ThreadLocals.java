package com.johnny.core.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocals {

    private static final AtomicInteger id = new AtomicInteger();

    private static final ThreadLocal<Integer> idGenerator = ThreadLocal.withInitial(id::incrementAndGet);

    public static Integer getId() {
        return idGenerator.get();
    }
}
