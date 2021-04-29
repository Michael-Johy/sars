package com.johnny.core.lang.spi.MySpi;

import com.johnny.core.lang.spi.api.IOperation;

/**
 * Created by johnny01.yang on 2016/6/15.
 */
public class DivisionOperationImpl implements IOperation {

    @Override
    public int operation(int numberA, int numberB) {
        System.out.println("divisionOperation");
        return numberA / numberB;
    }
}
