package com.johnny.core.lang.javac.byteArrayOutPutCompile;

public class ByteArrayClassLoader extends ClassLoader {

    private ByteArrayClassFileManager fileManager;


    public ByteArrayClassLoader(ByteArrayClassFileManager fileManager) {
        super();
        this.fileManager = fileManager;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = fileManager.getBytes(name);
        return defineClass(name, bytes, 0, bytes.length);
    }
}
