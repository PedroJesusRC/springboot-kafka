package com.pjrc.springbootkafka.infrastructure.kafka.producer.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjrc.springbootkafka.domain.model.Message;
import com.pjrc.springbootkafka.domain.port.MessagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerAdapter implements MessagePort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaProducerAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(Message message) {
        try {
            final String messageToSend = this.objectMapper.writeValueAsString(message);
            kafkaTemplate.send("my-topic", messageToSend);
        } catch (final JsonProcessingException e) {
            throw new IllegalArgumentException("Objeto para serializar no válido");
        }
    }
}
