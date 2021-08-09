package com.johnny.middleware.mq.rocketmq.example.producer;

import com.google.common.collect.Lists;
import com.johnny.middleware.mq.rocketmq.example.Constants;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Producer {

    public static void main(String[] args) throws Exception {
        syncSend();
    }

    /**
     * 同步发送: 可靠性高，比如重要的消息通知、短信通知
     */
    private static void syncSend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("syncSend producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("sync-message", ("message-sync" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message, (mqs, msg, arg) -> null, 1);
            System.out.println(result.getMsgId() + " " + result.getSendStatus());
        }
        producer.shutdown();
    }

    /**
     * 异步发送：用于对时间敏感的场景，发送端无法长时间等待broker的响应
     */
    private static void asyncSend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("asyncSend producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Message message = new Message("async-message", ("message-async" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch.countDown();
                    System.out.println("exception = " + message.getBuyerId());
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("exception = " + message.getBuyerId());
                }
            });
        }
        countDownLatch.await();
        producer.shutdown();
    }

    /**
     * 单向发送：不关心返回结果，用于日志等不重要场景
     */
    private static void oneWaySend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("onewaySend producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("oneway-message", ("message-oneway" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(message);
        }
        producer.shutdown();
    }

    /**
     * 延时消息, DelayTimeLevel默认的几个时间间隔
     */
    private static void sendDelayed() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("delayed producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("delay-message", ("message-sync" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            message.setDelayTimeLevel(3);
            producer.send(message);
        }
        producer.shutdown();
    }

    /**
     * 批量消息
     */
    private static void sendBatch() throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("delayed producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();

        List<Message> messageList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("batch-message", ("message-sync" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            messageList.add(message);
        }
        producer.send(messageList);

        producer.shutdown();
    }


}
