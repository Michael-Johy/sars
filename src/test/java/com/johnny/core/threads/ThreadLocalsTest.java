package com.johnny.core.threads;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreadLocalsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() throws InterruptedException {
        System.out.println("aa");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("ddd");
                System.out.println("1 id = " + ThreadLocals.getId());
                System.out.println("ddddd");
            }
        };

        //-1401181199
        Thread t = new Thread(r);
        t.start();
//
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("222222");
//                System.out.println("2 id = " + ThreadLocals.getId());
//                System.out.println("222222");
//            }
//        };

        //
//        Thread t1 = new Thread(r1);
//        t1.start();

        Thread.sleep(1000 * 10000);
    }

}