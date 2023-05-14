package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PersonaRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonaRolRepository extends JpaRepository<PersonaRolEntity, Long> {
    Optional<PersonaRolEntity> findByPersonaEntityIdAndRolEntityId(Long idPerson, Long idRole);
}
