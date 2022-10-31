package com.example.ProyectoInma.Controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioSesionControlador {

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/info-usuario")
    public String userInfo() {
        return "info-usuario";
    }
}
