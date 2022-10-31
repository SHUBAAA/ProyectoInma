package com.example.ProyectoInma.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoInma.Modelo.Boleta;
import com.example.ProyectoInma.Modelo.Producto;
import com.example.ProyectoInma.Repositorio.RepositorioProducto;





@Service
public class ServicioBoleta {
    @Autowired
    private RepositorioProducto data;
    public int calcularTotal(Boleta b){
        return b.getProductos().stream().mapToInt(p->p.getPrecio()).sum();
        
        
    }
    public List<Producto> listarBoleta() {
        return (List<Producto>) data.findAll();
    }
    
}
