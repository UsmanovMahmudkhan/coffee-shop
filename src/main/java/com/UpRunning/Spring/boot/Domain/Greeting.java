package com.UpRunning.Spring.boot.Domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "greet")
@Component
public class Greeting {
    String name;
    String massage;
}
