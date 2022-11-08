package com.example.ProyectoInma.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "rut", nullable = false, length = 20)
    private String rut;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    public User() {
    }

    public User(String email, String password, String rut, String nombre) {
        this.email = email;
        this.password = password;
        this.rut = rut;
        this.nombre = nombre;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )


    private Set<Rol> roles = new HashSet<>();

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public void addRole(Rol role) {
        this.roles.add(role);
    }
}