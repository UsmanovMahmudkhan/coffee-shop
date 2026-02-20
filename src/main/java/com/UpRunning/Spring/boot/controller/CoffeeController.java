package com.UpRunning.Spring.boot.controller;

import com.UpRunning.Spring.boot.Domain.Coffee;
import com.UpRunning.Spring.boot.Domain.CoffeeUpdateRequest;
import com.UpRunning.Spring.boot.Repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class CoffeeController {

    private final CoffeeRepository repository;

    public CoffeeController(CoffeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get")
    public Iterable<Coffee> getAll(){
        CoffeeController.log.info("returning coffees");
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Coffee> getById(@PathVariable UUID id){
        CoffeeController.log.info("Retrieved: {}", repository.findById(id));
        return repository.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Coffee> postCoffee(@RequestBody Coffee coffee){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(coffee));
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<Boolean>update(@PathVariable UUID id,@RequestBody CoffeeUpdateRequest request){
        if(repository.existsById(id)){
            var coffee=repository.findById(id);
            coffee.get().setName(request.getName());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(true);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable UUID id) {
        repository.deleteById(id);
    }

}
