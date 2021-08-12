package com.johnny.middleware.mq.kafka;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;

public class KProducer {
    public static void main(String[] args) {

        Map<String, Object> props = Maps.newHashMap();
        props.put("bootstrap.servers", "sandbox-1:9092,sandbox-2:9092,sandbox-3:9092");
        props.put("acks", "1");
        props.put("compression.type", "snappy");
        props.put("retries", 2);

        Producer<String, String> producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test01", "0");
        ProducerRecord<String, String> record1 = new ProducerRecord<String, String>("test01", "1");
        ProducerRecord<String, String> record2 = new ProducerRecord<String, String>("test01", "2");

        producer.send(record);
        producer.send(record1);
        producer.send(record2);


    }
}
