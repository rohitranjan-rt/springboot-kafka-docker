package com.springboot.kafka.service;

import com.springboot.kafka.entity.Message;
import com.springboot.kafka.repository.KafkaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @Autowired
    private KafkaRepository repository;

    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void consume(String message){
        log.info("Message received : {}", message);
        Message kafkaData = new Message();
        kafkaData.setMessage(message);

        repository.save(kafkaData);

    }

}
