package com.johnny.netty.person.server.handler;

import com.johnny.netty.person.server.codec.MessageFrameDecoder;
import com.johnny.netty.person.server.codec.MessageFrameEncoder;
import com.johnny.netty.person.server.codec.MessageProtocolDecoder;
import com.johnny.netty.person.server.codec.MessageProtocolEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.flush.FlushConsolidationHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.EventExecutorGroup;

public class PersonServerChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    private EventExecutorGroup eventExecutorGroup;

    public PersonServerChannelInitializer(EventExecutorGroup eventExecutorGroup) {
        this.eventExecutorGroup = eventExecutorGroup;
    }

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast("flushEnhance", new FlushConsolidationHandler())
                .addLast("frameDecoder", new MessageFrameDecoder())
                .addLast("protocolDecoder", new MessageProtocolDecoder())
                .addLast("logHandler", new LoggingHandler(LogLevel.INFO))
                .addLast("readIdleHandler", new PersonServerReadIdleHandler())
                .addLast("frameEncoder", new MessageFrameEncoder())
                .addLast("protocolEncoder", new MessageProtocolEncoder())
                .addLast(eventExecutorGroup, "serverHandler", new PersonServerHandler());
    }
}
