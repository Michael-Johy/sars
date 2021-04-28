package com.johnny.core.nio.netty.person.server;

import com.johnny.core.nio.netty.common.Constants;
import com.johnny.core.nio.netty.person.server.handler.PersonServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;

public class PersonServer {
    private int port;

    public PersonServer(int port) {
        this.port = port;
    }

    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("boss"));
        EventLoopGroup workerGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("worker"));
        EventExecutorGroup businessGroup = new UnorderedThreadPoolEventExecutor(10, new DefaultThreadFactory("business"));
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new PersonServerChannelInitializer(businessGroup))
                    .option(ChannelOption.SO_BACKLOG, 128) //连接队列长度，最大等待连接数量
                    .childOption(ChannelOption.SO_KEEPALIVE, false) //应用层协议一般打开，默认关闭
                    .childOption(ChannelOption.TCP_NODELAY, true); //是否禁用Nagel延迟算法，用来将较小的碎片连接成较大的报文发送，提高发送效率
            //bind and start to accept incoming connections
            ChannelFuture future = server.bind(port).sync();
            System.out.println("server start");
            future.channel().closeFuture().sync();
            System.out.println("channel closed");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("exception ");
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        PersonServer discardServer = new PersonServer(Constants.DISCARD_PORT);
        discardServer.run();
    }
}
