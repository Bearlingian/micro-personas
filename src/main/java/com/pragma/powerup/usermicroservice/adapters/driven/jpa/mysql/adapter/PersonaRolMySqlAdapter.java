package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.ProblemDataTruncateException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IPersonaRolEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRolRepository;
import com.pragma.powerup.usermicroservice.domain.exceptions.GeneralMessageException;
import com.pragma.powerup.usermicroservice.domain.model.PersonaRol;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaRolPersistenciaPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonaRolMySqlAdapter implements IPersonaRolPersistenciaPort {

    private final IPersonaRolRepository personaRolRepository;
    private final IPersonaRolEntityMapper personaRolEntityMapper;
    @Override
    public void save(PersonaRol record) {

        try{
            validarPersonaRol(record.getPersona().getId(),record.getRol().getId());
            personaRolRepository.save(personaRolEntityMapper.toEntity(record));
        }catch (Exception ex){
            throw new ProblemDataTruncateException("Probema para guardar.");
        }

    }

    private void validarPersonaRol(Long idPerona, Long idRol){
        if(personaRolRepository.findByPersonaEntityIdAndRolEntityId(idPerona,idRol).isPresent()){
            throw  new GeneralMessageException("No se puede registrar, intente mas tarde.");
        }
    }
}
