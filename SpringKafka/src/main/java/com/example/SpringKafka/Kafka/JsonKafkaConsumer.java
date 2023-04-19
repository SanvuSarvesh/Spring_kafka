package com.example.SpringKafka.Kafka;

import com.example.SpringKafka.PayLoad.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
    ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "Topic_json_1",groupId = "myGroup")
    public void consume(String message) throws JsonProcessingException {
        try{
            User user = objectMapper.readValue(message,User.class);
            logger.info("Message Received : " + user);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}

/*
*
* Spring Kafka provided JsonDeserializer, will convert User
* Json object to java User object
*
* */
