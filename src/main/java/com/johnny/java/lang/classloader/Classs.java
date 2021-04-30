package com.johnny.java.lang.classloader;

public class Classs {

    //inner class/interface
    private interface Call {
        void call();
    }

    //anonymous class
    private Call call1 = new Call() {
        @Override
        public void call() {
            System.out.println("call1");
        }
    };

    private Call call2 = new Call() {
        @Override
        public void call() {
            System.out.println("call1");
        }
    };

}
