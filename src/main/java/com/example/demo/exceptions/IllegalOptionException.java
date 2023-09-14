package com.example.demo.exceptions;

public class IllegalOptionException extends RuntimeException {
    private final String parameter;

    public IllegalOptionException(String parameter) {
        this.parameter = parameter;
    }

    public String getParamter() {
        return parameter;
    }
}
