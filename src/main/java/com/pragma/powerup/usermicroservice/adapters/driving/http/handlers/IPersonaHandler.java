package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PropietarioRequestDto;

public interface IPersonaHandler {

    void savePropietario(PropietarioRequestDto propietarioRequestDto);

}
