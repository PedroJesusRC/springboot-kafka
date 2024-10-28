package com.pjrc.springbootkafka.application;

import com.pjrc.springbootkafka.domain.model.Message;
import com.pjrc.springbootkafka.domain.port.MessagePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;


public class SendMessageUseCase {

    private final MessagePort messagePort;

    private final Logger logger = LoggerFactory.getLogger(SendMessageUseCase.class);

    public SendMessageUseCase(final MessagePort messagePort) {
        this.messagePort = messagePort;
    }

    public void execute(String message) {
        Message messageToSend = new Message(message, OffsetDateTime.now());
        messagePort.sendMessage(messageToSend);
        logger.info("Sending message: {}", message);
    }
}
