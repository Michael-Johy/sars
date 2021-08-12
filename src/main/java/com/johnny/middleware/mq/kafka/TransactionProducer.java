package com.johnny.middleware.mq.kafka;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;

public class TransactionProducer {
    public static void main(String[] args) {
        Map<String, Object> props = Maps.newHashMap();
        props.put("bootstrap.servers", "sandbox-1:9092,sandbox-2:9092,sandbox-3:9092");
        props.put("acks", "1");
        props.put("compression.type", "snappy");
        props.put("retries", 2);
        props.put("transactional.id", "trans-id");

        Producer<String, String> producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());

        producer.initTransactions();
        producer.beginTransaction();
        try {
            ProducerRecord<String, String> record1 = new ProducerRecord<>("topic1", "1");
            ProducerRecord<String, String> record2 = new ProducerRecord<>("topic1", "2");
            producer.send(record1);
            producer.send(record2);
        }catch (Exception e){
            producer.abortTransaction();
        }
        producer.commitTransaction();

    }
}
