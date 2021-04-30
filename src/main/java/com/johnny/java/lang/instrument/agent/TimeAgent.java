package com.johnny.java.lang.instrument.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Java Agent 是一类具有严格约束条件的java代码，MANIFEST.INF 包括premain-class、all
 * <p>
 * Java Agent
 * https://www.cnblogs.com/rickiyang/p/11368932.html
 * 监控工具: BTrace、Arthas
 * Bytecode: asm、cglib、javassist
 * <p>
 * 通过监听事件的方式工作，主要是监听类加载事件
 */
public class TimeAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain >> agentArgs = " + agentArgs + " , inst = " + inst.toString());
        inst.addTransformer(new TimeClassFileTransformer(), true);
    }

    public static void premain(String agentArgs) {

    }

    public static void agentmain(String agentArgs, Instrumentation inst) {

    }

    public static void agentmain(String agentArgs) {

    }

    private static class TimeClassFileTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            if ("java.lang.Thread".equals(className)) {

            }
            //使用字节码工具生存新类的方法
            return new byte[0];
        }
    }

}
