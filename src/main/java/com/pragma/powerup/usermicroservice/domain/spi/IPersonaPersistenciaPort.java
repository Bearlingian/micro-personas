package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Persona;

public interface IPersonaPersistenciaPort {

    Long savePerson(Persona persona);

    Boolean existsDocumentoIdentidad(String documentoIdentidad);

}
