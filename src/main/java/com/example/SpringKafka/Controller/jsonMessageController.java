package com.example.SpringKafka.Controller;

import com.example.SpringKafka.Kafka.JsonKafkaProducer;
import com.example.SpringKafka.PayLoad.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class jsonMessageController {
    //@Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    public jsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/postMessage")
    public ResponseEntity<String> publish(@RequestBody User user)
            throws JsonProcessingException {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to kafka topic.");
    }
}


//http://localhost:8080/api/v1/kafka/postMessage