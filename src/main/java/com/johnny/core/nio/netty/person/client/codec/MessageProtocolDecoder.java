package com.johnny.core.nio.netty.person.client.codec;

import com.johnny.core.nio.netty.common.Message;
import com.johnny.core.nio.netty.common.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class MessageProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        Message message = new ResponseMessage();
        message.decode(msg);
        out.add(message);
    }
}
