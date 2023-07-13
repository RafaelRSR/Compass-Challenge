package com.compass.Challenge.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


public class CarDTO {


    public long idChassi;

    @JsonProperty("name")
    @NotBlank(message = "Blank field not allowed!")
    public String name;
    @JsonProperty("brand")
    @NotBlank(message = "Blank field not allowed!")
    public String brand;
    @JsonProperty("color")
    @NotBlank(message = "Blank field not allowed!")
    public String color;
    @JsonProperty("fabricationYear")
    @NotBlank(message = "Blank field not allowed!")
    public String fabricationYear;

    public CarDTO() {
    }

    public CarDTO(long idChassi, String name, String brand, String color, String fabricationYear) {
        this.idChassi = idChassi;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
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

