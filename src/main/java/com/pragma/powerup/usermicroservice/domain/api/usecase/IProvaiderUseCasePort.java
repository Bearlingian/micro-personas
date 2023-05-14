package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.domain.model.Persona;

public interface IProvaiderUseCasePort {

    void validateCreatedFields(Persona persona);


}
