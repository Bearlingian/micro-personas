package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonaRepository extends JpaRepository<PersonaEntity, Long> {

    Optional<PersonaEntity> findByDocumentoIdentidad(String documentoIdentidad);

}
