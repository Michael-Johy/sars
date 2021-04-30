package com.johnny.java.concurrent.atomic;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.DoubleBinaryOperator;

public class DoubleAccumulatorDemo {

    public static void main(String[] args) {

        DoubleBinaryOperator a = Double::sum;

        DoubleAccumulator d = new DoubleAccumulator(a, 0d);

        d.accumulate(3);

        d.accumulate(1);

        System.out.println(d.get());
    }

}
