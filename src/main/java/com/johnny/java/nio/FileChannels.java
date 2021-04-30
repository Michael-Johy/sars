package com.johnny.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannels {

    public static void main(String[] args) throws Exception {
//        test1();
        transfer();
    }

    private static void test1() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/johnny/codes/github/utils-utils/src/main/resources/filechannel_test", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(5);

        int readBytes = channel.read(buf);
        System.out.println("bytes1 nums = " + readBytes);
        if (readBytes != 0) {
            buf.flip();
            for (int i = 0, limit = buf.limit(); i < limit; i++) {
                System.out.println((char) buf.get(i));
            }
        }

        buf.clear();

        readBytes = channel.read(buf);
        System.out.println("bytes nums = " + readBytes);
        while (buf.hasRemaining()) {
            System.out.println((char) buf.get());
        }

        channel.close();
        file.close();
    }

    private static void transfer() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/Users/johnny/codes/github/utils-utils/src/main/resources/tofilechannel_test", "rw");
        FileChannel toChannel = file.getChannel();

        RandomAccessFile fromFile = new RandomAccessFile("/Users/johnny/codes/github/utils-utils/src/main/resources/filechannel_test", "rw");
        FileChannel fromChannel = fromFile.getChannel();


        long size = toChannel.transferFrom(fromChannel, 0, fromChannel.size());
        System.out.println(size);

    }

}


