package com.johnny.middleware.mq.rocketmq.producer;

import com.johnny.middleware.mq.rocketmq.Constants;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;

public class TransactionProducer {
    public static void main(String[] args) throws Exception {

        String[] tags = new String[]{"tagA", "tagB", "tagC"};

        //创建事务监听器
        TransactionListener listener = new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if ("tagA".equalsIgnoreCase(msg.getTags())) {
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if ("tagB".equalsIgnoreCase(msg.getTags())) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else {
                    return LocalTransactionState.UNKNOW;
                }
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println(msg.getTags() + " body = " + new String(msg.getBody(), StandardCharsets.UTF_8));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        };

        TransactionMQProducer producer = new TransactionMQProducer("trans-producer-group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.setTransactionListener(listener);
        producer.start();

        for (int i = 0; i < 5; i++) {
            String tag = tags[i % tags.length];
            Message message = new Message("transTopic", tag, "key1",
                    ("rocket-trans" + i).getBytes(StandardCharsets.UTF_8));
            message.putUserProperty(MessageConst.PROPERTY_TRANSACTION_CHECK_TIMES, "5");
            message.putUserProperty(MessageConst.PROPERTY_CHECK_IMMUNITY_TIME_IN_SECONDS, "1");

            SendResult result = producer.sendMessageInTransaction(message, null);
            System.out.println("i = " + i + ", tag = " + tag + ", result = " + result.getSendStatus());
        }
    }
}
