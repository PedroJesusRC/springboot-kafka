package com.pjrc.springbootkafka.application;

import com.pjrc.springbootkafka.domain.port.MessagePort;


public class SendMessageUseCase {

    private final MessagePort messagePort;

    public SendMessageUseCase(final MessagePort messagePort) {
        this.messagePort = messagePort;
    }

    public void execute(String message) {
        messagePort.sendMessage(message);
        System.out.println("Sending message: " + message);
    }
}
