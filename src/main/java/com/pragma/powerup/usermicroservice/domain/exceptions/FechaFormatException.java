package com.pragma.powerup.usermicroservice.domain.exceptions;

public class FechaFormatException extends RuntimeException{
    public FechaFormatException() {
        super();
    }

    public FechaFormatException(String message) {
        super(message);
    }
}
