package com.example.ProyectoInma.Model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private String categoria;


    public Producto() {
    }

    public Producto(int id, String nombre, String descripcion, int cantidad, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }


}