package com.pjrc.springbootkafka.infrastructure.spring.config;

import com.pjrc.springbootkafka.application.SendMessageUseCase;
import com.pjrc.springbootkafka.domain.port.MessagePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public SendMessageUseCase sendMessageUseCase(final MessagePort messagePort) {
        return new SendMessageUseCase(messagePort);
    }
}
