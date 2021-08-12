package com.johnny.middleware.netty.person.client.handler;

import com.johnny.middleware.netty.person.client.codec.MessageFrameDecoder;
import com.johnny.middleware.netty.person.client.codec.MessageFrameEncoder;
import com.johnny.middleware.netty.person.client.codec.MessageProtocolDecoder;
import com.johnny.middleware.netty.person.client.codec.MessageProtocolEncoder;
import com.johnny.middleware.netty.person.client.dispatch.RequestPendingCenter;
import com.johnny.middleware.netty.person.client.dispatch.ResponseDispatcherHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class PersonClientChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    private RequestPendingCenter center;
    private KeepAliveHandler keepAliveHandler;

    public PersonClientChannelInitializer() {
        super();
    }

    public PersonClientChannelInitializer(RequestPendingCenter center) {
        super();
        this.center = center;
        keepAliveHandler = new KeepAliveHandler();
    }

    @Override
    protected void initChannel(NioSocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new PersonClientWriteIdleHandler());

        pipeline.addLast(new MessageFrameDecoder());
        pipeline.addLast(new MessageProtocolDecoder());
        if (null != center) {
            pipeline.addLast(new ResponseDispatcherHandler(center));
        }
        pipeline.addLast(new MessageFrameEncoder());
        pipeline.addLast(new MessageProtocolEncoder());
        pipeline.addLast(keepAliveHandler);
        pipeline.addLast(new LoggingHandler(LogLevel.INFO));
        pipeline.addLast(new PersonClientHandler());
    }
}
