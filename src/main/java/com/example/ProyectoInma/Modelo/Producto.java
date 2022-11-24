package com.example.ProyectoInma.Modelo;
import lombok.Data;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
public class Producto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    
    @ManyToOne
    @JoinColumn(name = "id_boleta")
    private Boleta boleta;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio")
    private int precio;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "cantidad")
    private int cantidad;


    public Producto() {

    }

    public Producto(int idProducto, Boleta boleta, String nombreProducto, int precio, Date fecha,
            String categoria, int cantidad) {
        this.idProducto = idProducto;
        this.boleta = boleta;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fecha = fecha;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    

    

}
