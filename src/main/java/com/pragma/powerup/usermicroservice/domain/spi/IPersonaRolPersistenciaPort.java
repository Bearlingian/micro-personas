package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.PersonaRol;

public interface IPersonaRolPersistenciaPort {

    void save(PersonaRol personaRol);
}
