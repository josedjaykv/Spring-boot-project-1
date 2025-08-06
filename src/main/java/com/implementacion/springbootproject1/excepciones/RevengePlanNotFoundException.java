package com.implementacion.springbootproject1.excepciones;

public class RevengePlanNotFoundException extends RuntimeException {
    public RevengePlanNotFoundException(String message) {
        super(message);
    }
}