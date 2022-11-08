package com.example.ProyectoInma.Controller;

import com.example.ProyectoInma.Servicio.ServicioBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorBoleta {
    @Autowired
    private ServicioBoleta servicioBoleta;

    @PostMapping("/añadirBoleta")
    public String añadirBoleta(HttpServletRequest request, Model model, @RequestParam("id") int id, @RequestParam("cantidad") int cantidad){
        servicioBoleta.añadirBoleta(id, cantidad);
        return "redirect:/caja";
    }
}
