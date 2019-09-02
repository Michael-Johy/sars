package com.johnny.sars.rule.java;


import com.johnny.sars.rule.java.fileObject.ByteArrayClassJavaFileObject;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: johnny
 * Date  : 2017-11-13 11:19
 */
public class CustomJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {

    private final Map<String, ByteArrayClassJavaFileObject> byteCodeCache = new LinkedHashMap<>();

    public CustomJavaFileManager(JavaFileManager fileManager) {
        super(fileManager);
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling) throws IOException {
        ByteArrayClassJavaFileObject javaFileObject = new ByteArrayClassJavaFileObject(className, kind);
        byteCodeCache.put(className, javaFileObject);
        return javaFileObject;
    }

    public ByteArrayClassJavaFileObject getJavaFileObjectImpl(String className) {
        return byteCodeCache.get(className);
    }

    public byte[] getBytes(String className) {
        ByteArrayClassJavaFileObject fileObject = byteCodeCache.get(className);
        if (fileObject != null) {
            return fileObject.getBytes();
        }
        return new byte[0];
    }

}
