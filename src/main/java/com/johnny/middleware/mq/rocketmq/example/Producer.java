package com.johnny.middleware.mq.rocketmq.example;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.CountDownLatch;

public class Producer {

    public static void main(String[] args) throws Exception {
        syncSend();
    }

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

    private static void asyncSend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("asyncSend producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Message message = new Message("sync-message", ("message-sync" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
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

    private static void oneWaySend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("onewaySend producer group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("sync-message", ("message-sync" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(message);
        }
        producer.shutdown();
    }
}
