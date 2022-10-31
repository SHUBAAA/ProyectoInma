package com.example.ProyectoInma.Servicio;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoInma.Modelo.Boleta;
import com.example.ProyectoInma.Modelo.Producto;
import com.example.ProyectoInma.Repositorio.RepositorioProducto;

import java.util.List;
import java.util.Optional;


@Service
public class ServicioProducto {

    @Autowired
    private RepositorioProducto data;
    


    public List<Producto> listar() {
        return (List<Producto>) data.findAll();
    }


    public Optional<Producto> listarid(int id) {
        return data.findById(id);
    }


    public int guardar(Producto p) {
        int respuesta = 0;
        Producto producto = data.save(p);
        if (!producto.equals(null)) {
            respuesta = 1;
        }
        return respuesta;
    }


    public void eliminar(int id) {
        data.deleteById(id);

    }

    public void agregarABoleta(Producto p,Boleta b) {
        b.agregarProducto(p);
        eliminar(p.getIdProducto());
    }
    public void descontarCantidad(Producto p, int cantidad){
        p.setCantidad(p.getCantidad()-cantidad);
        
    }

}

    

