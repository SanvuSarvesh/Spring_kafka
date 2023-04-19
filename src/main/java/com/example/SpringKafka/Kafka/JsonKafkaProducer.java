package com.example.SpringKafka.Kafka;

import com.example.SpringKafka.PayLoad.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String dataAsString = objectMapper.writeValueAsString(data);
        logger.info(String.format("Message sent %s : ",data.toString()));
        Message<String> message = MessageBuilder
                .withPayload(dataAsString)
                .setHeader(KafkaHeaders.TOPIC,"Topic_json_1")
                .build();
        logger.info("let's see what will happen_1.");
        kafkaTemplate.send(message);
    }
}
