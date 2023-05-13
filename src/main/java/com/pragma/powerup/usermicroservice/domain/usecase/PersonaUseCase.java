package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IPersonaServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Persona;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;

public class PersonaUseCase implements IPersonaServicePort {

    private final IPersonaPersistenciaPort personaPersistenciaPort;

    public PersonaUseCase(IPersonaPersistenciaPort personaPersistenciaPort) {
        this.personaPersistenciaPort = personaPersistenciaPort;
    }

    @Override
    public void savePropietario(Persona persona) {
        // validaciones de campos
        personaPersistenciaPort.savePropietario(persona);
    }


}
