package com.example.ProyectoInma.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
public class Boleta {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;


    public Boleta() {
    }


    public Boleta(Long id, Producto producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
