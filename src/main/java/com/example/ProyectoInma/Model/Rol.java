package com.example.ProyectoInma.Model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String name;

    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
    }

    public Rol(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
