package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class PropietarioRequestDto {


    @Schema(required = true, maxLength = 200)
    @Max(200)
    private String nombre;

    @Schema(required = true, maxLength = 200)
    private String apellido;

    @Schema(required = true, maxLength = 20)
    private String documentoIdentidad;

    @Schema(maxLength = 13, required = true, description = "Format numeric", example = "+1234567890")
    private String celular;

    @Schema(required = true, description = "Format: dd/MM/yyyy")
    private String fechaNacimiento;

    @Schema(required = true, maxLength = 200)
    private String email;

    @Schema(required = true)
    private String password;

}
