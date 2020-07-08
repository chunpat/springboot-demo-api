package com.chunpat.fengxiuapi.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@PropertySource(value = "classpath:ValidatonMessages.properties")
@Component
public class ValidatonMessagesConfiguration {
    private Map<String, String> messages = new HashMap<>();

    public void setMessage(Map<String, String> message) {
        this.messages = message;
    }

    public String getMessage(int name) {
        String message = messages.get(name);
        return message;
    }
}
