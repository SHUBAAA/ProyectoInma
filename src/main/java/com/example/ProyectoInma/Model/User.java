package com.example.ProyectoInma.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clave;
    private String roles;
    private String rut;
    private String email;

    public User() {
    }

    public User(String nombre, String clave, String roles, String rut, String email) {
        this.nombre = nombre;
        this.clave = clave;
        this.roles = roles;
        this.rut = rut;
        this.email = email;
    }
}
