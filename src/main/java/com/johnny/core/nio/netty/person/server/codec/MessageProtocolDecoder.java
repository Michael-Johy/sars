package com.johnny.core.nio.netty.person.server.codec;

import com.johnny.core.nio.netty.common.Message;
import com.johnny.core.nio.netty.common.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        log.info("decode byteBuf to message");
        Message message = new RequestMessage();
        message.decode(msg);
        out.add(message);
        log.info("decode byteBuf end");
    }
}
