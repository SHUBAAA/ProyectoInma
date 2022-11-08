package com.example.ProyectoInma.Controller;

import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Model.ProductoBoleta;
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
        return "boleta";
    }


    @PostMapping("/saveboleta")
    public String save(@Validated ProductoBoleta p, Model model) {
        servicioBoleta.save(p);
        return "redirect:/caja";
    }

    @GetMapping("/eliminarprodboleta/{id}")
    public String delete(@PathVariable int id) {
        servicioBoleta.delete(id);
        return "redirect:/caja";
    }
}
