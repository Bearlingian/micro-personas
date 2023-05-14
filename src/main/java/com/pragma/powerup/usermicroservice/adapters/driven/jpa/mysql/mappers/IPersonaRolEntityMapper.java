package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PersonaRolEntity;
import com.pragma.powerup.usermicroservice.domain.model.PersonaRol;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPersonaRolEntityMapper {

    @Mapping(target = "personaEntity.id", source = "persona.id")
    @Mapping(target = "rolEntity.id", source = "rol.id")
    PersonaRolEntity toEntity(PersonaRol personaRol);
}
