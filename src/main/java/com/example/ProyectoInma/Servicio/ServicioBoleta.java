package com.example.ProyectoInma.Servicio;

<<<<<<< HEAD
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
=======

import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Model.ProductoBoleta;
import com.example.ProyectoInma.Repository.RepositorioProductoBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioBoleta {
    @Autowired
    private RepositorioProductoBoleta dataprodboleta;
    public int Total(List<ProductoBoleta> boleta){
        return boleta.stream().mapToInt(p->p.getPrecio()*p.getCantidad()).sum();


    }


    public void save(ProductoBoleta p) {
        dataprodboleta.save(p);
    }

    public List<ProductoBoleta> mostrar() {
        return (List<ProductoBoleta>) dataprodboleta.findAll();
    }

    public void delete(int id) {
        dataprodboleta.deleteById(id);
    }
    public void borrarTodo(){
        dataprodboleta.deleteAll();
    }
}

>>>>>>> ayuda
