package com.example.SpringKafka.Configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic kafkaTopic(){
        return TopicBuilder.name("Topic_1")
                //.partitions(5) // if we want custom partitions
                // here I am using default partition
                .build();
    }
    @Bean
    public NewTopic kafkaJsonTopic(){
        return TopicBuilder.name("Topic_json_1")
                .build();
    }
}

// https:/stream.wikimedia.org/v2/stream/recentchange
// esjewett.github.io/wm-eventsource-demo/