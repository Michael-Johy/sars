package com.johnny.java.lang.instrument.tools.bytecode.javassist;

import com.johnny.java.lang.instrument.tools.bytecode.cases.Call;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

public class MainTest {

    private static final String PRINT_CALL_NAME = "com.johnny.java.lang.instrument.tools.bytecode.cases.PrintCall";
    private static final String CALL_NAME = "com.johnny.java.lang.instrument.tools.bytecode.cases.Call";

    public static void main(String[] args) throws Exception {
        modifyClass();
    }

    private static void modifyClass() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass printCallClass = classPool.getCtClass(PRINT_CALL_NAME);
        CtClass callClass = classPool.get(CALL_NAME);
        printCallClass.setInterfaces(new CtClass[]{callClass});
        printCallClass.writeFile("/Users/johnny/codes/github/sars-utils/printcall");

        //error
        Class<?> clazz = printCallClass.toClass();

        Call call = (Call) clazz.newInstance();
        call.call();
    }
}
