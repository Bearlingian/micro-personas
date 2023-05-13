package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Persona;

public interface IPersonaPersistenciaPort {

    void savePropietario(Persona persona);

}
