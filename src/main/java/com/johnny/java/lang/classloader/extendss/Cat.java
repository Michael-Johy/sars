package com.johnny.java.lang.classloader.extendss;

public class Cat extends Animal {

    protected void cry() {
        System.out.println("cat cat ...");
        super.cry();
    }
}
