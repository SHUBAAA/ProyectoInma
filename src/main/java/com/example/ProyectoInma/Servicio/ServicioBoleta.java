package com.example.ProyectoInma.Servicio;

import com.example.ProyectoInma.Model.Boleta;
import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Model.ProductoBoleta;
import com.example.ProyectoInma.Repository.RepositorioBoleta;
import com.example.ProyectoInma.Repository.RepositorioProductoBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServicioBoleta {
    @Autowired
    private RepositorioBoleta repositorioBoleta;
    @Autowired
    private ProductoService servicioProducto;
    @Autowired
    private RepositorioProductoBoleta repositorioProductoBoleta;

    public Boleta añadirBoleta(int id, int cantidad) {
        Boleta boleta = new Boleta();
        ProductoBoleta productoBoleta = new ProductoBoleta();
        productoBoleta.setCantidad(cantidad);
        productoBoleta.setDate(new Date());
        productoBoleta.setProducto(servicioProducto.getProductoById(id));
        boleta.getProductos().add(productoBoleta);
        boleta.setFecha(new Date());
        return repositorioBoleta.save(boleta);


    }
    public void save(Producto p) {
        .save(p);
    }
}

