package com.johnny.core.nio.netty.person.server.codec;

import com.johnny.core.nio.netty.common.Message;
import com.johnny.core.nio.netty.common.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        log.info("decode byteBuf to message");
        Message message = new RequestMessage();
        message.decode(msg);
        out.add(message);
        log.info("decode byteBuf end");
    }
}
