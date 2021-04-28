package com.johnny.core.nio.netty.person.client.codec;

import com.johnny.core.nio.netty.common.Message;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class MessageProtocolEncoder extends MessageToMessageEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) {
        ByteBuf buf = Unpooled.buffer();
        msg.encode(buf);
        out.add(buf);
    }
}
