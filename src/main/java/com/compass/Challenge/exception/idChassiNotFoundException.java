package com.compass.Challenge.exception;

public class idChassiNotFoundException extends RuntimeException {
    public idChassiNotFoundException(String s) {
        super("Car not found!");
    }
}

