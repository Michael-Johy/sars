package com.johnny.java.lang.spi;


import com.johnny.java.lang.spi.cases.IOperation;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by johnny01.yang on 2016/6/15.
 */
public class MainTest {

    public static void main(String[] args) {
        ServiceLoader serviceLoader = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            IOperation operation = iterator.next();
            System.out.println(operation.operation(6, 3));
        }
    }

}
