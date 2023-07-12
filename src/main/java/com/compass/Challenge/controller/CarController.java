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
    private CarService carService;

    @GetMapping("/{idChassi}")
    public ResponseEntity<Object> findById(@PathVariable Long idChassi) {
        try {
            Car car = carService.findById(idChassi);
            return ResponseEntity.ok(car);
        } catch (idChassiNotFoundException e) {
            String errorMessage = "idChassi not found!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
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

    @ExceptionHandler(idChassiNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleIdChassiNotFoundException() {
    }

}

