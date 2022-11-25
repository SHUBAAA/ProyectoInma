package com.example.ProyectoInma.Servicio;


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


    public void save(ProductoBoleta p) {
        dataprodboleta.save(p);
    }

    public List<ProductoBoleta> mostrar() {
        return dataprodboleta.findAll();
    }

    public void delete(int id) {
        dataprodboleta.deleteById(id);
    }
    public void borrarTodo(){
        dataprodboleta.deleteAll();
    }
}

