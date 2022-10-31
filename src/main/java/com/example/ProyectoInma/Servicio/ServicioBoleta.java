package com.example.ProyectoInma.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoInma.Modelo.Boleta;
import com.example.ProyectoInma.Modelo.Producto;
import com.example.ProyectoInma.Repositorio.RepositorioProducto;





@Service
public class ServicioBoleta {
    //se llama al repositorio
    @Autowired
    private RepositorioProducto repositorioBoleta;

    //esta funcion calcula el total de la venta
    public int calcularTotal(Boleta b){
        return b.getProductos().stream().mapToInt(p->p.getPrecio()).sum();
        
        
    }
    //Esta funcion lista los productos de la boleta
    public List<Producto> listarBoleta() {
        return (List<Producto>) repositorioBoleta.findAll();
    }
    
}
