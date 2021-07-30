package com.johnny.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public final int a = get();

    private static int get() {
        return atomicInteger.addAndGet(10);
    }

    public static void main(String[] args) throws Exception {

        String a = "";


        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 3});


    }
}
