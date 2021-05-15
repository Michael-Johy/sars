package com.johnny.java.threads;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public final int a = get();

    private static int get() {
        return atomicInteger.addAndGet(10);
    }

    public static void main(String[] args) throws Exception {

//        MyTest test = new MyTest();
//        System.out.println(test.a);
//
//        MyTest test1 = new MyTest();
//        System.out.println(test1.a);
        LocalDate now = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        System.out.println(formatter.format(now));


        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());

        System.out.println(now.toString());

    }
}
