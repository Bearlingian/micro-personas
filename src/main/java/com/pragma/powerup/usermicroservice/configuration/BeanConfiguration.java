package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.PersonaMysqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IPersonaEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRepository;
import com.pragma.powerup.usermicroservice.domain.api.IPersonaServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;
import com.pragma.powerup.usermicroservice.domain.usecase.PersonaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPersonaRepository personaRepository;

    private final IPersonaEntityMapper personaEntityMapper;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public IPersonaServicePort personaServicePort(){
        return new PersonaUseCase(personaPersistenciaPort());
    }

    @Bean
    public IPersonaPersistenciaPort personaPersistenciaPort(){
        return new PersonaMysqlAdapter(personaRepository,personaEntityMapper);
    }


}
