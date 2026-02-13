package com.UpRunning.Spring.boot.Domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
public class Coffee {
    private UUID id;
    private String name;

    public Coffee(String name) {
        id= UUID.randomUUID();
        this.name = name;
    }
}
