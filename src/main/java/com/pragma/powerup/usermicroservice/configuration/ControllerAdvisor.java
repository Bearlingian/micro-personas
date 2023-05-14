package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.ProblemDataTruncateException;
import com.pragma.powerup.usermicroservice.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;


@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, WRONG_CREDENTIALS_MESSAGE));
    }

    @ExceptionHandler(CamposNulosVacionException.class)
    public ResponseEntity<Object> handleCamposNulosVacionException(CamposNulosVacionException exception) {

        if(exception.getMessage() != null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, exception.getMessage()));
        }else if (exception.getListFieldError().size() != 0){
            List<String> errorMessages = new ArrayList<>();
            errorMessages.addAll(exception.getListFieldError());
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }

        return null;
    }


    @ExceptionHandler(EmailFormatException.class)
    public ResponseEntity<Map<String, String>> handleEmailFormatException(EmailFormatException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, EMAIL_FORMAT_EXCEPTION));
    }

    @ExceptionHandler(FechaFormatException.class)
    public ResponseEntity<Map<String, String>> handleFechaFormatException(FechaFormatException exception) {

        if(exception.getMessage() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, exception.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, FECHA_FORMAT_EXCEPTION));
    }

    @ExceptionHandler(PhoneFormatException.class)
    public ResponseEntity<Map<String, String>> handlePhoneFormatException(PhoneFormatException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PHONE_FORMAT_EXCEPTION));
    }

    @ExceptionHandler(DocumentoIdentidadException.class)
    public ResponseEntity<Map<String, String>> handleDocumentoIdentidadException(DocumentoIdentidadException exception) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, exception.getMessage()));
    }

    @ExceptionHandler(GeneralMessageException.class)
    public ResponseEntity<Map<String, String>> handleGeneralMessageException(GeneralMessageException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, exception.getMessage()));
    }

    @ExceptionHandler(ProblemDataTruncateException.class)
    public ResponseEntity<Map<String, String>> handleProblemDataTruncateException(ProblemDataTruncateException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, exception.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, Constants.HTTP_PETICION_EXCEPTION));
    }


}
