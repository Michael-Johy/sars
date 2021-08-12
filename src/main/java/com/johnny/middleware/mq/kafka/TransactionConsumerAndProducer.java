package com.johnny.middleware.mq.kafka;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Map;

public class TransactionConsumerAndProducer {
    public static void main(String[] args) {
        Map<String, Object> producerProps = Maps.newHashMap();
        producerProps.put("bootstrap.servers", "sandbox-1:9092,sandbox-2:9092,sandbox-3:9092");
        producerProps.put("transactional.id", "trans-id");
        Producer<String, String> producer = new KafkaProducer<>(producerProps, new StringSerializer(), new StringSerializer());

        Map<String, Object> props = Maps.newHashMap();
        props.put("bootstrap.servers", "sandbox-1:9092,sandbox-2:9092,sandbox-3:9092");
        props.put("isolation.level", "read_committed");
        props.put("group.id", "consumer-group");
        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Lists.newArrayList("test01"));

        producer.initTransactions();

        producer.beginTransaction();
        ConsumerRecords<String, String> consumerRecord = consumer.poll(Duration.ofSeconds(30));
        for (ConsumerRecord<String, String> item : consumerRecord) {
            System.out.println("value = " + item.value());
            producer.send(new ProducerRecord<>("test02", item.value()));
        }
//        producer.sendOffsetsToTransaction(consumer.offsetsForTimes(), "consumer-group");
        producer.commitTransaction();

        System.out.println("consumer end");
    }
}
