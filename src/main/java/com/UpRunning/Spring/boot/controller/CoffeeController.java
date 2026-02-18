package com.UpRunning.Spring.boot.controller;

import com.UpRunning.Spring.boot.Domain.Coffee;
import com.UpRunning.Spring.boot.Domain.CoffeeUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class CoffeeController {
    private List<Coffee>coffees;

    public CoffeeController(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    @GetMapping("/get")
    public List<Coffee> getAll(){
        CoffeeController.log.info("returning coffees");
        return coffees;
    }

    @GetMapping("/{id}")
    public Coffee getById(@PathVariable UUID id){
        Coffee found=null;
        for(Coffee c:coffees){
            if(c.getId().equals(id)){
                found=c;
            }
        }
        return found;
    }

    @PostMapping("/post")
    public ResponseEntity<Coffee>postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coffee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean>update(@PathVariable UUID id,@RequestBody CoffeeUpdateRequest request){
        for(Coffee c:coffees){
            if(c.getId().equals(id)){
                c.setName(request.getName());
               return ResponseEntity
                       .status(HttpStatus.ACCEPTED)
                       .body(true);
            }
        }

       return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(false);
    }

    @DeleteMapping("/del/{id}")
    public Boolean del(@PathVariable UUID id) {
        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                coffees.remove(c);
                return true;
            }

        }
        return false;
    }

}
