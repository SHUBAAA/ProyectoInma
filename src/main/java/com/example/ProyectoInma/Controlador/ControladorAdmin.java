package com.example.ProyectoInma.Controlador;



import com.example.ProyectoInma.Modelo.Usuario;
import com.example.ProyectoInma.Servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorAdmin {

    //se llama al servicio de usuario
    @Autowired
    private ServicioUsuario userservice;

    //se obtienen los datos del usuario para poder listarlos
    @GetMapping("/admin")
    public String listar(Model model) {
        List<Usuario> usuario = userservice.listar();
        model.addAttribute("usuarios", usuario);
        return "admin";
    }

    //Esta funcion nos permite registrar usuarios y luego de registro redirecciona a la ruta de admin
    @PostMapping("/register")
    public String guardarUsuario(Usuario usuario, SessionStatus status) {

        usuario.setClave(userservice.cifrarClave(usuario.getClave()));
        userservice.guardar(usuario);
        status.setComplete();
        return "redirect:/admin";
    }

    //Esta funcion nos permite editar los usuarios ya ingresados
    @GetMapping("/editaruser/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = userservice.getID(id);
        model.addAttribute("usuario", usuario);
        return "moduser";
    }

    //esta funcion nos permite borrar usuario registrados
    @GetMapping("/eliminaruser/{id}")
    public String delete(@PathVariable Long id) {
        userservice.delete(id);
        return "redirect:/admin";
    }
}
