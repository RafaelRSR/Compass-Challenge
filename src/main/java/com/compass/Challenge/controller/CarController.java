package com.compass.Challenge.controller;

import com.compass.Challenge.dtos.CarDTO;
import com.compass.Challenge.entity.Car;
import com.compass.Challenge.exception.idChassiNotFoundException;
import com.compass.Challenge.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    public CarService carService;

    @GetMapping("/get/{idChassi}")
    public ResponseEntity<Object> findById(@PathVariable Long idChassi) {
        try {
            Car car = carService.findById(idChassi);
            return ResponseEntity.ok(car);
        } catch (idChassiNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found!");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<String> postCar(@RequestBody CarDTO carDto) {
        try {
            carService.saveCar(carDto);
            return ResponseEntity.ok("Car saved successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

