package com.compass.Challenge.controller;

import com.compass.Challenge.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.compass.Challenge.dtos.CarDTO;
import com.compass.Challenge.service.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{idChassi}")
    public Car findByID(@PathVariable Long idChassi) {
        return carService.findById(idChassi);
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
