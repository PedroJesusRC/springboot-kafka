package com.pjrc.springbootkafka.domain.port;

import com.pjrc.springbootkafka.domain.model.Message;

public interface MessagePort {

    void sendMessage(Message message);
}
