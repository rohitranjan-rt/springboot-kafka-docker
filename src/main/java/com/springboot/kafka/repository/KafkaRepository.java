package com.springboot.kafka.repository;

import com.springboot.kafka.entity.Message;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepository extends JpaRepository<Message, Long> {
}
