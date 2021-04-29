package com.johnny.core.nio.netty.person.client.handler;

import com.johnny.core.nio.netty.common.Message;
import com.johnny.core.nio.netty.common.MessageHeader;
import com.johnny.core.nio.netty.common.RequestMessage;
import com.johnny.core.nio.netty.person.OperationTypes;
import com.johnny.core.nio.netty.person.model.KeepAliveRequest;
import com.johnny.core.nio.netty.util.MessageIDUtils;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class KeepAliveHandler extends ChannelDuplexHandler {

    private static final Logger log = LoggerFactory.getLogger(KeepAliveHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt == IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT) {
            log.info("write idle happen. so need to send keepalive to keep connection not closed by server");
            Message message = new RequestMessage();
            message.setHeader(new MessageHeader(1, OperationTypes.KEEP_ALIVE.getOpCode(), MessageIDUtils.nextID()));
            message.setBody(new KeepAliveRequest(System.currentTimeMillis()));
            ctx.writeAndFlush(message);
        }
        super.userEventTriggered(ctx, evt);
    }
}
