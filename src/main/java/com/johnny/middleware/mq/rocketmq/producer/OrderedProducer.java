package com.johnny.middleware.mq.rocketmq.producer;

import com.google.common.collect.Lists;
import com.johnny.middleware.mq.rocketmq.Constants;
import com.johnny.middleware.mq.rocketmq.model.Order;
import com.johnny.utils.json.JsonUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class OrderedProducer {
    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("orderedProducer-group");
        producer.setNamesrvAddr(Constants.NAMESRV);
        producer.start();

        List<Order> orderList = mockOrders();
        for (int i = 0; i < orderList.size(); i++) {
            Message message = new Message("orders12", "tagA", JsonUtils.toJSONString(orderList.get(i)).getBytes(StandardCharsets.UTF_8));
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    long orderId = (Long) arg;
                    int index = (int) (orderId % mqs.size());
                    MessageQueue messageQueue = mqs.get(index);
                    System.out.println("broker=" + messageQueue.getBrokerName() + ", queue=" + messageQueue.getQueueId());
                    return messageQueue;
                }
            }, orderList.get(i).getOrderId());
            System.out.println("i = " + i + " send result = " + sendResult.getSendStatus().name());
        }
    }

    private static List<Order> mockOrders() {
        List<Order> result = Lists.newArrayList();
        result.add(new Order(1, "下单"));
        result.add(new Order(2, "下单"));
        result.add(new Order(9, "下单"));

        result.add(new Order(1, "付款"));
        result.add(new Order(2, "付款"));
        result.add(new Order(9, "付款"));
        return result;
    }
}
