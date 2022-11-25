package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Repository.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoService {

    @Autowired
    private RepoProducto dataProducto;


    public List<Producto> mostrar() {
        return dataProducto.findAll();
    }


    public Optional<Producto> getID(int id) {
        return dataProducto.findById(id);
    }



    public void save(Producto producto) {
        dataProducto.save(producto);
    }


    public void delete(int id) {
        dataProducto.deleteById(id);
    }
}
