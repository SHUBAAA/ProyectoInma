package com.example.ProyectoInma.Controlador;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.Authenticator;

@Controller
public class InicioSesionControlador implements WebMvcConfigurer {

    //esto nos permite tener la direccion de login para poder iniciar sesion con los usuarios
    @GetMapping("/login")
    public String iniciarSesion() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }

<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Controlador/InicioSesionControlador.java
=======
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("403");
    }
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/Controller/InicioSesionControlador.java
}
