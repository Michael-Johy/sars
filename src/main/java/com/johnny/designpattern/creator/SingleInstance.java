package com.johnny.designpattern.creator;

public class SingleInstance {

    private SingleInstance() {
    }

    private static volatile SingleInstance instance = null;

    public static SingleInstance getInstance() {
        if (null == instance) {
            synchronized (SingleInstance.class) {
                if (null == instance) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
