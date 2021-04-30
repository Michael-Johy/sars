package com.johnny.java.lang.javac.byteArrayOutPutCompile;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * Description: This class representing Byte[]-Format byteCode
 * <p>
 * Author: johnny
 * Date  : 2017-11-14 09:51
 */
public class ByteArrayClassJavaFileObject extends SimpleJavaFileObject {

    /**
     * Byte code created by the java will be stored in this ByteArrayOutputStream so
     * that we can later get the byte array out of it
     */
    private ByteArrayOutputStream byteCode = new ByteArrayOutputStream();

    public ByteArrayClassJavaFileObject(String name, Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
    }

    /**
     * @return compiled byte code
     */
    public byte[] getBytes() {
        return byteCode.toByteArray();
    }

    /**
     * Will provide the java with an output stream that leads
     * to our byte array. This way the java will write everything
     * into the byte array that we will instantiate later
     */
    @Override
    public OutputStream openOutputStream() throws IOException {
        return byteCode;
    }
}
