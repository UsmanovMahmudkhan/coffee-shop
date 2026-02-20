package com.UpRunning.Spring.boot.controller;

import com.UpRunning.Spring.boot.Domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final Greeting greeting;

    @Value("${name : Alexbek}")
    private String name;

    @Value("${massage: fuck off}")
    private String massage;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    public String getName(){
        return name;
    }

    @GetMapping("/mss")
    public String getMassage(){
        return massage;
    }

    @GetMapping("/config/name")
    public String getName2(){
        return greeting.getName();
    }

    @GetMapping("/config/mss")
    public String getMss2(){
        return greeting.getMassage();
    }
}
