package com.johnny.core.nio.netty.person.server.codec;

import com.johnny.core.nio.netty.common.Message;
import com.johnny.sars.json.JsonUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageProtocolEncoder extends MessageToMessageEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        log.info("encode response msg = " + JsonUtils.toJSONString(msg));
        ByteBuf buf = Unpooled.buffer();
        msg.encode(buf);
        out.add(buf);
    }
}
