package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.PersonaMysqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.PersonaRolMySqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IPersonaEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IPersonaRolEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IPersonaRolRepository;
import com.pragma.powerup.usermicroservice.domain.api.IPersonaServicePort;
import com.pragma.powerup.usermicroservice.domain.api.usecase.IProvaiderUseCasePort;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaRolPersistenciaPort;
import com.pragma.powerup.usermicroservice.domain.usecase.PersonaUseCase;
import com.pragma.powerup.usermicroservice.domain.usecase.provaider.ProvaiderUseCase;
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

    private final IPersonaRolRepository personaRolRepository;
    private final IPersonaRolEntityMapper personaRolEntityMapper;

    @Bean
    public IPersonaServicePort personaServicePort(){
        return new PersonaUseCase(personaPersistenciaPort(),provaiderUseCasePort(),personaRolPersistenciaPort());
    }
    @Bean
    public IPersonaRolPersistenciaPort personaRolPersistenciaPort(){
        return new PersonaRolMySqlAdapter(personaRolRepository,personaRolEntityMapper);
    }

    @Bean
    public IPersonaPersistenciaPort personaPersistenciaPort(){
        return new PersonaMysqlAdapter(personaRepository,personaEntityMapper,passwordEncoder);
    }



    @Bean
    public IProvaiderUseCasePort provaiderUseCasePort(){
        return new ProvaiderUseCase(personaPersistenciaPort());
    }

}
