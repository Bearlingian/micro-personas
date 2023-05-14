package com.pragma.powerup.usermicroservice.domain.exceptions;

import java.util.List;

public class CamposNulosVacionException extends RuntimeException{

    private List listFieldError;
    public CamposNulosVacionException() {
    }

    public CamposNulosVacionException(String message) {
        super(message);
    }

    public CamposNulosVacionException(List ex) {
        this.listFieldError = ex;
    }

    public List getListFieldError() {
        return listFieldError;
    }

}
