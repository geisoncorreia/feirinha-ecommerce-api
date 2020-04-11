package com.example.apirest.demo.controller;

import com.example.apirest.demo.exception.ResourceNotFoundException;
import com.example.apirest.demo.model.Car;
import com.example.apirest.demo.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") UUID carId) throws ResourceNotFoundException {
      Car car = carRepository.findById(carId)
              .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado para o id :: " + carId));

      return ResponseEntity.ok().body(car);
    }

    @PostMapping(value = "/car/create/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
}
