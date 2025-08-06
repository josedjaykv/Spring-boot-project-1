package com.implementacion.springbootproject1.excepciones;

public class BullyNotFoundException extends RuntimeException {
    public BullyNotFoundException(String message) {
        super(message);
    }
}