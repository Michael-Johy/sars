package com.johnny.java.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;


// similar to AtomicLongArray & AtomicReferenceArray
public class IntegerArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[]{1, 2, 3});

        array.set(1, 3);
        int v = array.getAndAdd(0, 3);

        System.out.println(v);
    }

}
