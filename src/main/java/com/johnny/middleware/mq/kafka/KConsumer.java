package com.johnny.middleware.mq.kafka;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Map;

public class KConsumer {
    public static void main(String[] args) {
        Map<String, Object> props = Maps.newHashMap();
        props.put("bootstrap.servers", "sandbox-1:9092,sandbox-2:9092,sandbox-3:9092");
        Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Lists.newArrayList("test01"));

        ConsumerRecords<String, String> consumerRecord = consumer.poll(Duration.ofSeconds(30));
        for (ConsumerRecord<String, String> item : consumerRecord) {
            System.out.println("value = " + item.value());
        }

        consumer.commitSync();
        System.out.println("consumer end");
    }
}
