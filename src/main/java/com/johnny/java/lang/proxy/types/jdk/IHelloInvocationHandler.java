package com.johnny.java.lang.proxy.types.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Author: johnny
 * Date  : 2017-02-08 11:17
 */
public class IHelloInvocationHandler implements InvocationHandler {

    private final Object object;

    public IHelloInvocationHandler(Object object) {
        super();
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object result = method.invoke(object, args);

        System.out.println("after");

        return result;
    }
}
