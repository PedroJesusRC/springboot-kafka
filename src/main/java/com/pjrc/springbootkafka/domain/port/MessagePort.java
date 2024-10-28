package com.pjrc.springbootkafka.domain.port;

public interface MessagePort {

    void sendMessage(String message);
}
