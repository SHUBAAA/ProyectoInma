package com.example.ProyectoInma.Modelo;
import javax.persistence.*;



import lombok.Data;
import java.sql.Date;
import java.util.Collection;




@Entity
@Table(name="boleta")
@Data
public class Boleta {
    @Id
    @Column(name = "id_boleta", nullable = false)
    private Long idboleta;

    ////////////////////////////////
    @OneToMany(mappedBy = "boleta")
    @Column(name = "productos", nullable = false)
    private Collection<Producto> productos;

    @Column(name = "total", nullable = false)
    private Long total;

    @Column(name = "fecha_emision",nullable = false)
    private Date fechaEmision;



    public Boleta() {
    }



    public Boleta(Long idboleta, Collection<Producto> productos, Long total, Date fechaEmision) {
        this.idboleta = idboleta;
        this.productos = productos;
        this.total = total;
        this.fechaEmision = fechaEmision;
    }
public void agregarProducto(Producto p){
productos.add(p);
}
    

    

}
