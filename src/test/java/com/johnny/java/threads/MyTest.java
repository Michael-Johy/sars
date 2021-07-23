package com.johnny.java.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public final int a = get();

    private static int get() {
        return atomicInteger.addAndGet(10);
    }

    public static void main(String[] args) throws Exception {

        String a = "";


    }
}
