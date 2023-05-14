package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions;

public class ProblemDataTruncateException extends RuntimeException{
    public ProblemDataTruncateException(String message) {
        super(message);
    }
}
