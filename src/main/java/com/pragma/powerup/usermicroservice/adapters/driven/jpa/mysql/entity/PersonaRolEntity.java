package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona_rol")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonaEntity personaEntity;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity rolEntity;

}
