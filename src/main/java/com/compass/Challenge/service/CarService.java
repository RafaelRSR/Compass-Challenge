package com.compass.Challenge.service;

import com.compass.Challenge.dtos.CarDTO;
import com.compass.Challenge.entity.Car;
import com.compass.Challenge.exception.idChassiNotFoundException;
import com.compass.Challenge.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findById(Long idChassi) {
        return carRepository.findById(idChassi)
                .orElseThrow(() -> new idChassiNotFoundException("Car not found!"));
    }


    public void saveCar(CarDTO carDTO) {
        try {
            validateCarBrand(carDTO.getBrand());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Brand not allowed.");
        }


        validateNotNull(carDTO.getName());
        validateNotNull(carDTO.getBrand());
        validateNotNull(carDTO.getColor());
        validateNotNull(carDTO.getFabricationYear());

        Car carEntity = new Car();
        carEntity.setIdChassi(carDTO.getIdChassi());
        carEntity.setName(carDTO.getName());
        carEntity.setBrand(carDTO.getBrand());
        carEntity.setColor(carDTO.getColor());
        carEntity.setFabricationYear(carDTO.getFabricationYear());

        carRepository.save(carEntity);
    }

    public void validateCarBrand(String brand) {
        final String[] allowedBrands = {"Ford", "Chevrolet", "BMW", "Volvo"};
        if (!Arrays.asList(allowedBrands).contains(brand)) {
            throw new IllegalArgumentException("Brand not allowed.");
        }
    }

    public void validateNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Field null not allowed");
        }
    }
}
