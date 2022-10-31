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

    //se llama al repositorio
    @Autowired
    private RepositorioProducto repositorioProducto;
    

    //funcion encargada de listar los productos
    public List<Producto> listar() {
        return (List<Producto>) repositorioProducto.findAll();
    }

    //esta funcion tambien nos permite buscar productos por su id
    public Optional<Producto> buscarProducto(int id) {
        return repositorioProducto.findById(id);
    }

    //Esta funcion guarda los productos en la base de datos
    public int guardar(Producto p) {
        int respuesta = 0;
        Producto producto = repositorioProducto.save(p);
        if (!producto.equals(null)) {
            respuesta = 1;
        }
        return respuesta;
    }

    //Esta funcion permite eliminar productos
    public void eliminar(int id) {
        repositorioProducto.deleteById(id);

    }
    //esta funcion nos permite agregar los productos a una boleta y luego elimina producto del inventario
    public void agregarABoleta(Producto p,Boleta b) {
        b.agregarProducto(p);
        eliminar(p.getIdProducto());
    }
    //Esta funcion descuenta a la cantidad de productos, la cantidad agregada a la boleta
    public void descontarCantidad(Producto p, int cantidad){
        p.setCantidad(p.getCantidad()-cantidad);
        
    }

}

    

