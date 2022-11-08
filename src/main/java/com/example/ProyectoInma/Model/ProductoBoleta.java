package com.example.ProyectoInma.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "productoboleta")
public class ProductoBoleta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cantidad;

    @Column(nullable = false)
    private String fecha;

    private String nombre;

    private int precio;


    public ProductoBoleta() {
    }
}
