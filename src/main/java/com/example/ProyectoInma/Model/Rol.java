package com.example.ProyectoInma.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String name;

    public Rol() { }

    public Rol(String name) {
        this.name = name;
    }

    public Rol(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
