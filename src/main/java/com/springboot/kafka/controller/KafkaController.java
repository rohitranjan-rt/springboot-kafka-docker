package com.springboot.kafka.controller;

import com.springboot.kafka.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/test")
    public String test() {
        log.info("Test in controller");
        return "Test successful";
    }
    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        log.info("Message in controller : {}", message);
        kafkaProducerService.sendMessage(message);
        return "Message send successfully: ";
    }
}
