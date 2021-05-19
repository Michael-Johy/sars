package com.johnny.middleware.mq.kafka.example;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    }
}
