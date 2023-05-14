package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PersonaEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.ProblemDataTruncateException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IPersonaEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRepository;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.model.Persona;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaRolPersistenciaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PersonaMysqlAdapter implements IPersonaPersistenciaPort {

    private final IPersonaRepository personaRepository;
    private final IPersonaEntityMapper personaEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long savePerson(Persona persona) {

        try {
            persona.setPassword(passwordEncoder.encode(persona.getPassword()));
            return personaRepository.save(personaEntityMapper.toEntity(persona)).getId();
        }catch (Exception e){
            throw new ProblemDataTruncateException("Probema para guardar.");
        }

    }

    @Override
    public Boolean existsDocumentoIdentidad(String documentoIdentidad) {
        return personaRepository.existsByDocumentoIdentidad(documentoIdentidad);
    }


}
