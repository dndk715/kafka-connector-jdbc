package com.example.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OracleTableConsumer {
    @KafkaListener(topics = "oracle-YOUR_TABLE", groupId = "oracle-consumer-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
} 