package com.pjrc.springbootkafka.infrastructure.kafka.producer.adapter;

import com.pjrc.springbootkafka.domain.port.MessagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerAdapter implements MessagePort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("my-topic", message);
    }
}
