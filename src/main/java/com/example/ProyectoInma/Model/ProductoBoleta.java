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

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto",nullable = false,updatable = false)
    private Producto producto;

    public ProductoBoleta(int id, int cantidad, Date date, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.date = date;
        this.producto = producto;
    }

    public ProductoBoleta() {
    }
}
