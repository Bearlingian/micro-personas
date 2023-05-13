package com.pragma.powerup.usermicroservice.domain.model;

import java.util.Date;

public class Persona {

    private Long id;
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private String celular;
    private Date fechaNacimiento;
    private String email;
    private String password;
    private Long id_rol;


    public Persona(Long id, String nombre, String apellido, String documentoIdentidad, String celular, Date fechaNacimiento, String email, String password, Long id_rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.password = password;
        this.id_rol = id_rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }
}
