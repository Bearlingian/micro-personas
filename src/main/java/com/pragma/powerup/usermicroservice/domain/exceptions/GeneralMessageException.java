package com.pragma.powerup.usermicroservice.domain.exceptions;

public class GeneralMessageException extends RuntimeException{
    public GeneralMessageException(String message) {
        super(message);
    }
}
