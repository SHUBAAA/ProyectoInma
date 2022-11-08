package com.example.ProyectoInma.Model;


import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Transient
    private int valorTotal;
    @Transient
    private int nroProductos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductoBoleta> productos = new HashSet<ProductoBoleta>();


    public Boleta() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    //public int getValorTotal() {
    // int suma = 0;
    //  for (ProductoBoleta producto : this.productos){
    //      suma = suma + producto.getProducto().getPrecio()*producto.getCantidad();
    //   }
    //   return suma;
    // }


    public int getNroProductos() {
        return this.productos.size();
    }


    public Set<ProductoBoleta> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoBoleta> productos) {
        this.productos = productos;
    }
}
