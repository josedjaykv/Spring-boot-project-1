package com.implementacion.springbootproject1.excepciones;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}