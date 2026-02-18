package com.UpRunning.Spring.boot.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Entity
public class Coffee {
    @Id
    private UUID id;
    private String name;

    public Coffee() {
    }

    public Coffee(String name) {
        id= UUID.randomUUID();
        this.name = name;
    }
}
