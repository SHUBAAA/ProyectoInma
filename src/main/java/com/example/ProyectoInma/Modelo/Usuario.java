package com.example.ProyectoInma.Modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "clave",nullable = false)
    private String clave;
    @Column(name = "roles",nullable = false)
    private String roles;
    @Column(name = "rut",nullable = false)
    private String rut;
    @Column(name = "email",nullable = false)
    private String email;

    public Usuario() {
    }

    public Usuario(String nombre, String clave, String roles, String rut, String email) {
        this.nombre = nombre;
        this.clave = clave;
        this.roles = roles;
        this.rut = rut;
        this.email = email;
    }
}
