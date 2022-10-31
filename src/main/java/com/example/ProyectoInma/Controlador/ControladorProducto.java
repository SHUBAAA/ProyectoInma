package com.example.ProyectoInma.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProyectoInma.Modelo.Boleta;
import com.example.ProyectoInma.Modelo.Producto;
import com.example.ProyectoInma.Servicio.ServicioProducto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class ControladorProducto {
   
    @Autowired
    private ServicioProducto service;
   
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Producto> productos = service.listar();
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String agregar(Model model) {
        model.addAttribute("productos", new Producto());
        return "form";
    }


    @PostMapping("/guardar")
    public String guardar(@Valid Producto p, Model model) {
        service.guardar(p);
        return "redirect:/listar";
    }
    @PostMapping("/agregarABoleta")
    public void agregarABoleta(@Valid Producto p,@Valid Boleta b,int cantidad, Model model) {
        if(p.getCantidad()>cantidad){
        service.agregarABoleta(p,b);
        service.descontarCantidad(p, cantidad);
        }
        
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Producto> producto = service.listarid(id);
        model.addAttribute("productos", producto);
        return "form";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        service.eliminar(id);
        return "redirect:/listar";
    }
}
