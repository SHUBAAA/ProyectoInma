package com.example.ProyectoInma.Model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fecha = new Date(System.currentTimeMillis());

    @Column(nullable = false)
    private int precio;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private String categoria;


    public Producto() {
    }

    public Producto(int id, String nombre, int precio, int cantidad, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    public Producto(String nombre, int precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
}