package com.example.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OracleTableConsumer {
    
    @KafkaListener(topics = "oracle-YOUR_TABLE", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload OracleTableData data) {
        System.out.println("Received data: " + data);
        System.out.println("ID: " + data.getId());
        System.out.println("Name: " + data.getName());
        System.out.println("Description: " + data.getDescription());
        System.out.println("Created At: " + data.getCreatedAt());
    }
} 