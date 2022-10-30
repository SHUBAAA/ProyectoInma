package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Repository.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaService {
    @Autowired
    private RepoProducto dataProducto;



    public List<Producto> listarBoleta() {
        return (List<Producto>) dataProducto.findAll();
    }
}
