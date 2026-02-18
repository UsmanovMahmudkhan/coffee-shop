package com.UpRunning.Spring.boot.Repository;

import com.UpRunning.Spring.boot.Domain.Coffee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CoffeeRepository extends CrudRepository<Coffee, UUID>{

}
