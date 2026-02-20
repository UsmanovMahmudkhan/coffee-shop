package com.UpRunning.Spring.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Value("${name : Alexbek}")
    private String name;

    @Value("${massage: fuck off}")
    private String massage;

    @GetMapping
    public String getName(){
        return name;
    }

    @GetMapping("/mss")
    public String getMassage(){
        return massage;
    }
}
