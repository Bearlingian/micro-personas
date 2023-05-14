package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PropietarioRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IPersonaHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IPersonaRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IPersonaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class PersonaHandlerImpl implements IPersonaHandler {

    private final IPersonaServicePort personaServicePort;
    private final IPersonaRequestMapper personaRequestMapper;

    @Override
    public void savePropietario(PropietarioRequestDto requestDto) {
        personaServicePort.savePropietario(personaRequestMapper.toPropietario(requestDto));
    }


}
