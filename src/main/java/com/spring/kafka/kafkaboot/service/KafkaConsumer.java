package com.spring.kafka.kafkaboot.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka-demo", groupId = "kafka-demo")
    public void consume(String message) throws IOException {
        System.out.printf("Consumed message : %s%n", message);
    }
}