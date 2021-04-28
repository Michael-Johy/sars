package com.johnny.core.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class SocketChannels {
    public static void main(String[] args) {

    }

    private static void test1() throws IOException {
        Selector selector = Selector.open();

        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);

        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT);

        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey key : selectionKeys) {
                SocketChannel channel1 = (SocketChannel) key.channel();
                ByteBuffer buf = ByteBuffer.allocate(10);
                int readBytes = channel1.read(buf);

                channel1.write(buf);
                System.out.println(readBytes);
            }
        }

    }

}
