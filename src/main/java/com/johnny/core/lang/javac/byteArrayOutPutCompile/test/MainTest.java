package com.johnny.core.lang.javac.byteArrayOutPutCompile.test;

import com.johnny.core.lang.javac.byteArrayOutPutCompile.ByteArrayClassLoader;
import com.johnny.core.lang.javac.byteArrayOutPutCompile.compile.ByteArrayClassJavaCompiler;

public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        ByteArrayClassJavaCompiler compiler = new ByteArrayClassJavaCompiler();

//        compiler.compiler(.className, ClassPathOutCompile.SOURCE_CODE);

        ByteArrayClassLoader loader = new ByteArrayClassLoader(compiler.getJavaFileManager());

//        Class<?> clazz = loader.loadClass(ClassPathOutCompile.className);

    }

}
