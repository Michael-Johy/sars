package com.johnny.designpattern.singleinstance;

public class Animal {

    private Animal() {
    }

    private static volatile Animal instance = null;

    public static Animal getInstance() {
        if (null == instance) {
            synchronized (Animal.class) {
                if (null == instance) {
                    instance = new Animal();
                }
            }
        }
        return instance;
    }
}
