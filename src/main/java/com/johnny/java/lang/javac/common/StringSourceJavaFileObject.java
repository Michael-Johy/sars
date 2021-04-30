package com.johnny.java.lang.javac.common;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;


/**
 * Description: JavaFileObject representing String-Format sourceCode & Byte[]-Format byteCode
 * <p>
 * Author: johnny
 * Date  : 2017-11-13 11:06
 */
public class StringSourceJavaFileObject extends SimpleJavaFileObject {

    /**
     * sourceCode representing the source code to be compiled
     */
    private String sourceCode;


    /**
     * This constructor will store the source code in the internal sourceCode
     * and register it as a source code , using a URI containing the class full name
     *
     * @param className  name of the public class in the source code
     * @param sourceCode Java Source Code to java
     */
    public StringSourceJavaFileObject(String className, String sourceCode) {
        super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.sourceCode = sourceCode;
    }

    /**
     * The FileManager will invoke this method to get sourceCode to be compiled
     *
     * @return sourceCode
     */
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        if (sourceCode == null) {
            throw new UnsupportedOperationException("sourceCode is null");
        }
        return sourceCode;
    }
}
