package com.johnny.core.lang.proxy.types.jdk;

import com.johnny.core.lang.proxy.cases.HelloImpl;
import com.johnny.core.lang.proxy.cases.IHello;

import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        IHello iHello = new HelloImpl();
        IHelloInvocationHandler myHandler = new IHelloInvocationHandler(iHello);

        IHello iHelloProxy = (IHello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IHello.class}, myHandler);

        iHelloProxy.hello();
    }
}
