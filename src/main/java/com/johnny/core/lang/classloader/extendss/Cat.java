package com.johnny.core.lang.classloader.extendss;

public class Cat extends Animal {
    @Override
    protected void cry() {
        System.out.println("cat cat ...");
        super.cry();
    }
}
