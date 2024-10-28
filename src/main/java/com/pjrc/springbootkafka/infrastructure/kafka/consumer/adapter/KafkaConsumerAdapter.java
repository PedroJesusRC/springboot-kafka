package com.pjrc.springbootkafka.infrastructure.kafka.consumer.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjrc.springbootkafka.domain.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class KafkaConsumerAdapter {

    private final ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerAdapter.class);

    @Autowired
    public KafkaConsumerAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        if (StringUtils.hasLength(message)) {
            try {
                final Message messageReceived = this.objectMapper.readValue(message, Message.class);
                logger.info("Received message: {}", messageReceived);
            } catch (final JsonProcessingException e) {
                throw new IllegalArgumentException("Mensaje para deserializar no válido");
            }
        }
    }
}
