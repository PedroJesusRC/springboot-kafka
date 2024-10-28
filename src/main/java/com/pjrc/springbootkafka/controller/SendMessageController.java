package com.pjrc.springbootkafka.controller;

import com.pjrc.springbootkafka.application.SendMessageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    SendMessageUseCase sendMessageUseCase;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        sendMessageUseCase.execute(message);
        return "Message sent: " + message;
    }


}
