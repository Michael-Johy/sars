package com.johnny.middleware.netty.person.client.handler;

import com.johnny.middleware.netty.common.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PersonClientHandler extends SimpleChannelInboundHandler<Message> {
    private static final Logger log = LoggerFactory.getLogger(PersonClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("client channel active");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        log.info("channel read0 msg = " + msg);
    }
}
