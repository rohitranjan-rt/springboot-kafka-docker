package com.springboot.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.rmi.server.LogStream.log;

@Slf4j
@Service
public class KafkaProducerService {

    private static final String TOPIC = "my_topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        log("Message in service : " + message);
        kafkaTemplate.send(TOPIC, message);
        log("Message sent : " + message);
    }

}
