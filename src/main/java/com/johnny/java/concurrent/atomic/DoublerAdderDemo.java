package com.johnny.java.concurrent.atomic;

import java.util.concurrent.atomic.DoubleAdder;

public class DoublerAdderDemo {

    public static void main(String[] args) {
        DoubleAdder d = new DoubleAdder();
        d.add(1);
        d.add(2);
        System.out.println(d.doubleValue());
        System.out.println(d.sum());
        d.reset();
        System.out.println(d.doubleValue());

    }
}
