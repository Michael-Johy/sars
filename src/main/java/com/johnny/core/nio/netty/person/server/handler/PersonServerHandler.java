package com.johnny.core.nio.netty.person.server.handler;

import com.johnny.core.nio.netty.common.Message;
import com.johnny.core.nio.netty.common.ResponseMessage;
import com.johnny.core.nio.netty.person.model.PersonRequest;
import com.johnny.core.nio.netty.person.model.PersonResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonServerHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("server channel active");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        ByteBuf buf = ctx.alloc().buffer();

        log.info("server channel read0");
        PersonRequest request = (PersonRequest) msg.getBody();
        PersonResponse response = new PersonResponse(request.getId(), "name=" + request.getId());

        Message message = new ResponseMessage();
        message.setHeader(msg.getHeader());
        message.setBody(response);

        ctx.writeAndFlush(message);
    }

    //读取16次之后flush，有问题
    // 1.业务逻辑没完成
    // 2.不好控制
    // 推荐使用  FlushConsolidationHandler
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel registered");
    }


}
