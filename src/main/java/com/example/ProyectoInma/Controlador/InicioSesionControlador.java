package com.example.ProyectoInma.Controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioSesionControlador {

    //esto nos permite tener la direccion de login para poder iniciar sesion con los usuarios
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

}
