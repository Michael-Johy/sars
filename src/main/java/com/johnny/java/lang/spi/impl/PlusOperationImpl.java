package com.johnny.java.lang.spi.impl;


import com.johnny.java.lang.spi.cases.IOperation;

/**
 * Created by johnny01.yang on 2016/6/15.
 */
public class PlusOperationImpl implements IOperation {

    @Override
    public int operation(int numberA, int numberB) {
        System.out.println("plusOperation");
        return numberA + numberB;
    }
}
