package com.johnny.netty.person.server.codec;

import com.johnny.netty.common.Message;
import com.johnny.utils.json.JsonUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageProtocolEncoder extends MessageToMessageEncoder<Message> {
    private static final Logger log = LoggerFactory.getLogger(MessageProtocolEncoder.class);


    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        log.info("encode response msg = " + JsonUtils.toJSONString(msg));
        ByteBuf buf = Unpooled.buffer();
        msg.encode(buf);
        out.add(buf);
    }
}
