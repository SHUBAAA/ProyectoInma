package com.example.ProyectoInma.Controller;


import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class ControladorProducto {

    @Autowired
    private ProductoService productoservice;


    @GetMapping({"/main", "/"})
    public String listar(Model model) {
        List<Producto> productos = productoservice.mostrar();
        model.addAttribute("productos", productos);
        return "index";
    }


    @GetMapping("/editarprod/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Producto> producto = productoservice.getID(id);
        model.addAttribute("producto", producto);
        return "modproducto";
    }


    @PostMapping("/save")
    public String save(@Validated Producto p, Model model) {
        productoservice.save(p);
        return "redirect:/main";
    }


    @GetMapping("/eliminarprod/{id}")
    public String delete(@PathVariable int id) {
        productoservice.delete(id);
        return "redirect:/main";
    }
}