package com.compass.Challenge.dtos;

import com.compass.Challenge.entity.Car;
import jakarta.validation.constraints.NotNull;

public class CarDTO {


    @NotNull
    public long idChassi;

    @NotNull
    public String name;
    @NotNull
    public String brand;
    @NotNull
    public String color;
    @NotNull
    public String fabricationYear;

    public CarDTO(long idChassi, String name, String brand, String color, String fabricationYear) {
        this.idChassi = idChassi;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public CarDTO() {
    }


    public long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(long idChassi) {
        this.idChassi = idChassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "idChassi=" + idChassi +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", fabricationYear='" + fabricationYear + '\'' +
                '}';
    }
}

