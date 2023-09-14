package com.example.demo.exceptions;

public class IllegalValueException extends RuntimeException {


    private final String passedValue;
    private final String finalValue;

    public IllegalValueException(String passedValue, String finalValue) {
        this.passedValue = passedValue;
        this.finalValue = finalValue;
    }
}
