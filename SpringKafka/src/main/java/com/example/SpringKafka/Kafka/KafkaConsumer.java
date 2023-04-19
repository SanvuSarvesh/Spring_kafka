package com.example.SpringKafka.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "Topic_1",groupId = "myGroup")
    public void receiveMessage(String message){
        logger.info(String.format("Message receiver %s :",message));
    }
}