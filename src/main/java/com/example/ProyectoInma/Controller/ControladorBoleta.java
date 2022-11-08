package com.example.ProyectoInma.Controller;

import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Servicio.ProductoService;
import com.example.ProyectoInma.Servicio.ServicioBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ControladorBoleta {
    @Autowired
    private ServicioBoleta servicioBoleta;
    @Autowired
    private ProductoService servicioProd;

    @GetMapping("/editarBoleta/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Producto> producto = servicioProd.getID(id);
        model.addAttribute("producto", producto);
        return "modproducto";
    }

    @PostMapping("/añadirBoleta")
    public String añadirBoleta(HttpServletRequest request, Model model, @RequestParam("id") int id, @RequestParam("cantidad") int cantidad){
        servicioBoleta.añadirBoleta(id, cantidad);
        return "redirect:/caja";
    }

    @PostMapping("/save")
    public String save(@Validated Producto p, Model model) {
        servicioProd.save(p);
        return "redirect:/main";
    }
}
