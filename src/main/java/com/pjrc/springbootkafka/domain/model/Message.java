package com.pjrc.springbootkafka.domain.model;

import java.time.OffsetDateTime;

public class Message {

    String text;

    OffsetDateTime date;

    public Message(String text, OffsetDateTime date) {
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
