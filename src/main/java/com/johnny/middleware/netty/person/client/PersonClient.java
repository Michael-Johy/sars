package com.johnny.middleware.netty.person.client;

import com.johnny.middleware.netty.common.Constants;
import com.johnny.middleware.netty.common.Message;
import com.johnny.middleware.netty.common.MessageHeader;
import com.johnny.middleware.netty.common.RequestMessage;
import com.johnny.middleware.netty.person.OperationTypes;
import com.johnny.middleware.netty.person.client.dispatch.RequestPendingCenter;
import com.johnny.middleware.netty.person.client.dispatch.ResponseFuture;
import com.johnny.middleware.netty.person.client.handler.PersonClientChannelInitializer;
import com.johnny.middleware.netty.person.model.PersonRequest;
import com.johnny.middleware.netty.person.model.PersonResponse;
import com.johnny.middleware.netty.util.MessageIDUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;


/**
 * 响应分发客户端
 */
public class PersonClient {

    private static final Logger log = LoggerFactory.getLogger(PersonClient.class);


    private final RequestPendingCenter center;
    private final ChannelFuture future;

    public PersonClient() {
        center = new RequestPendingCenter();
        NettyClient nettyClient = new NettyClient(Constants.DISCARD_PORT, center);
        future = nettyClient.start();
    }

    private static class NettyClient {
        private final int port;
        private final RequestPendingCenter center;
        private final NioEventLoopGroup eventLoopGroup;

        private NettyClient(int port, RequestPendingCenter center) {
            this.port = port;
            this.center = center;
            this.eventLoopGroup = new NioEventLoopGroup();
        }

        public ChannelFuture start() {
            ChannelFuture future = null;
            try {
                Bootstrap client = new Bootstrap();
                client.group(new NioEventLoopGroup())
                        .channel(NioSocketChannel.class)
                        .handler(new PersonClientChannelInitializer(center))
                        // 多个网卡，绑定同一个端口；让关闭连接的端口更早可使用, time_wait=2MSL(maximum segment lifetime)
                        .option(NioChannelOption.SO_REUSEADDR, false)
                        .option(NioChannelOption.CONNECT_TIMEOUT_MILLIS, 1000);
                //start the client
                future = client.connect(new InetSocketAddress(port)).sync();
            } catch (Exception e) {
                System.out.println("client exception");
            } finally {
                assert future != null;
                future.channel().closeFuture().addListener(future1 -> {
                    if (future1.isDone()) {
                        log.info("shutDown client ...");
                        eventLoopGroup.shutdownGracefully();
                    }
                });
            }
            return future;
        }
    }

    public PersonResponse query(PersonRequest request) throws ExecutionException, InterruptedException {
        // create messageId-future and register to requestPendingCenter
        long messageId = MessageIDUtils.nextID();
        ResponseFuture future1 = new ResponseFuture();
        center.add(messageId, future1);

        // create and flush message with messageId
        Message message = new RequestMessage();
        message.setHeader(new MessageHeader(1, OperationTypes.PERSON.getOpCode(), messageId));
        message.setBody(request);
        future.channel().writeAndFlush(message);

        //block
        return (PersonResponse) future1.get();
    }

    public static void main(String[] args) throws Exception {
        PersonClient clientV2 = new PersonClient();
        for (int i = 0; i < 2; i++) {
            PersonRequest request = new PersonRequest(1);
            PersonResponse response = clientV2.query(request);
            System.out.println("resp id = " + response.getId());
            System.out.println("resp name = " + response.getName());
        }
    }
}
