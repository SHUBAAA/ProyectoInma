package com.example.ProyectoInma.Controller;


import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Model.ProductoBoleta;
import com.example.ProyectoInma.Servicio.ProductoService;
import com.example.ProyectoInma.Servicio.ServicioBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControladorCaja {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private ServicioBoleta servicioBoleta;

    @GetMapping({"/caja"})
    public String listar(Model model) {
        List<Producto> productos = productoService.mostrar();
        List<ProductoBoleta> productosboleta = servicioBoleta.mostrar();
        model.addAttribute("productosboleta", productosboleta);
        model.addAttribute("productos", productos);
        return "caja";
    }

}
