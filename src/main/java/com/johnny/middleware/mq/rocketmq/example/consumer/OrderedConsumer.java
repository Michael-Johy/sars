package com.johnny.middleware.mq.rocketmq.example.consumer;

import com.johnny.middleware.mq.rocketmq.example.Constants;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.nio.charset.StandardCharsets;

public class OrderedConsumer {
    public static void main(String[] args) throws Exception {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("orderConsumer-group");
        consumer.setNamesrvAddr(Constants.NAMESRV);

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setMessageModel(MessageModel.CLUSTERING);

        consumer.subscribe("orders12", "*");

        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            context.setAutoCommit(true);
            System.out.println("broker=" + context.getMessageQueue().getBrokerName() + ", queue=" + context.getMessageQueue().getQueueId());
            System.out.println("consumeThread = " + Thread.currentThread().getName());

            for (MessageExt messageExt : msgs) {
                System.out.println("body = " + new String(messageExt.getBody(), StandardCharsets.UTF_8));
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
        System.out.println("consumer started");
    }
}
