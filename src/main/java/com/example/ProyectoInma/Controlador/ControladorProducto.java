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
   //se llama al servicio de producto
    @Autowired
    private ServicioProducto servicioProducto;
   //Esta funcion lista los productos disponibles
    @GetMapping({"/listar","/"})
    public String listar(Model model) {
        List<Producto> productos = servicioProducto.listar();
        model.addAttribute("productos", productos);
        return "index";
    }
    //Esta funcion permite crear productos
    @GetMapping("/nuevo")
    public String agregar(Model model) {
        model.addAttribute("productos", new Producto());
        return "form";
    }

    //esta funcion nos permite guardar productos en la base de datos
    @PostMapping("/guardar")
    public String guardar(@Valid Producto p, Model model) {
        servicioProducto.guardar(p);
        return "redirect:/listar";
    }
    //Esta funcion agrega los productos a la boleta en caso tener la cantidad solicitada
    @PostMapping("/agregarABoleta")
    public void agregarABoleta(@Valid Producto p,@Valid Boleta b,int cantidad, Model model) {
        if(p.getCantidad()>cantidad){
        servicioProducto.agregarABoleta(p,b);
        servicioProducto.descontarCantidad(p, cantidad);
        }
        
    }
    //llama a un producto mediante su id para poder asi modificarlo
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Producto> producto = servicioProducto.buscarProducto(id);
        model.addAttribute("productos", producto);
        return "form";
    }

    //llama a un producto mediante su id para poder eliminarlo
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        servicioProducto.eliminar(id);
        return "redirect:/listar";
    }
}
