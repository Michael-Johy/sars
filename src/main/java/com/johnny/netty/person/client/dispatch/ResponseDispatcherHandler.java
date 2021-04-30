package com.johnny.netty.person.client.dispatch;

import com.johnny.netty.common.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ResponseDispatcherHandler extends SimpleChannelInboundHandler<Message> {

    private RequestPendingCenter center;

    public ResponseDispatcherHandler(RequestPendingCenter center) {
        super();
        this.center = center;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        center.setResult(msg.getHeader().getMessageId(), msg.getBody());
    }
}
