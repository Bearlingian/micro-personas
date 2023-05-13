package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PropietarioRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPersonaRequestMapper {

    Persona toPropietario(PropietarioRequestDto propietarioRequestDto);
}
