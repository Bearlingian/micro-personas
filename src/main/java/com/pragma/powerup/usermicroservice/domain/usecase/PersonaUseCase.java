package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IPersonaServicePort;
import com.pragma.powerup.usermicroservice.domain.api.usecase.IProvaiderUseCasePort;
import com.pragma.powerup.usermicroservice.domain.model.Persona;
import com.pragma.powerup.usermicroservice.domain.model.PersonaRol;
import com.pragma.powerup.usermicroservice.domain.model.Rol;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaRolPersistenciaPort;
import org.springframework.transaction.annotation.Transactional;


public class PersonaUseCase implements IPersonaServicePort {

    private final IPersonaPersistenciaPort personaPersistenciaPort;
    private final IProvaiderUseCasePort provaiderUseCasePort;
    private final IPersonaRolPersistenciaPort personaRolPersistenciaPort;

    public PersonaUseCase(IPersonaPersistenciaPort personaPersistenciaPort,IProvaiderUseCasePort provaiderUseCasePort, IPersonaRolPersistenciaPort personaRolPersistenciaPort) {
        this.personaPersistenciaPort = personaPersistenciaPort;
        this.provaiderUseCasePort = provaiderUseCasePort;
        this.personaRolPersistenciaPort = personaRolPersistenciaPort;
    }

    @Override
    public void savePropietario(Persona persona) {
        // validaciones de campos
        provaiderUseCasePort.validateCreatedFields(persona);

        //Guardar Persona
        Long idPersona = personaPersistenciaPort.savePerson(persona);

        // Asigrnar Rol
        PersonaRol record = new PersonaRol();
            Persona recordPersona = new Persona();
            recordPersona.setId(idPersona);
            Rol recordRol = new Rol();
            recordRol.setId(Constants.PROVIDER_ROLE_ID);
            record.setPersona(recordPersona);
            record.setRol(recordRol);
        personaRolPersistenciaPort.save(record);

    }



}
