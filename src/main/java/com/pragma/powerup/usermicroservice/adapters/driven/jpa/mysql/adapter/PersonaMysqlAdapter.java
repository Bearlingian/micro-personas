package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IPersonaEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRepository;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.model.Persona;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PersonaMysqlAdapter implements IPersonaPersistenciaPort {

    private final IPersonaRepository personaRepository;
    private final IPersonaEntityMapper personaEntityMapper;
   // private final PasswordEncoder passwordEncoder;

    @Override
    public void savePropietario(Persona persona) {

        persona.setId_rol(Constants.PROVIDER_ROLE_ID);
      //  persona.setPassword(passwordEncoder.encode(persona.getPassword()));

        personaRepository.save(personaEntityMapper.toEntity(persona));

    }


}
