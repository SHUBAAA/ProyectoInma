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

    private int total;




    public ProductoBoleta() {
    }

    public int getTotal() {
        int suma=0;
        suma = this.cantidad*this.precio;
        return suma;
    }
}
