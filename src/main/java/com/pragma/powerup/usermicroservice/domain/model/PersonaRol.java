package com.pragma.powerup.usermicroservice.domain.model;

public class PersonaRol {

    private Long id;
    private Persona persona;
    private Rol rol;

    public PersonaRol() {
    }

    public PersonaRol(Long id, Persona persona, Rol rol) {
        this.id = id;
        this.persona = persona;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
