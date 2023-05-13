package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class PropietarioRequestDto {

    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private String celular;
    private Date fechaNacimiento;
    private String email;
    private String password;

}
