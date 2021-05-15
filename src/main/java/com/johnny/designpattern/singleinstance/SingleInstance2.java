package com.johnny.designpattern.singleinstance;

public class SingleInstance2 {
    private SingleInstance2() {
    }

    private static final SingleInstance2 holder = new SingleInstance2();

    public static SingleInstance2 getHolder() {
        return holder;
    }

}
