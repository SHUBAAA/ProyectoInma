package com.example.ProyectoInma.Controlador;



<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Controlador/ControladorAdmin.java
import com.example.ProyectoInma.Modelo.Usuario;
import com.example.ProyectoInma.Servicio.ServicioUsuario;
=======
import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Servicio.UserService;
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/Controller/ControladorAdmin.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;


@Controller
public class ControladorAdmin {

    //se llama al servicio de usuario
    @Autowired
<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Controlador/ControladorAdmin.java
    private ServicioUsuario servicioUsuario;

    //se obtienen los datos del usuario para poder listarlos
    @GetMapping("/admin")
    public String listar(Model model) {
        List<Usuario> usuario = servicioUsuario.listar();
        model.addAttribute("usuarios", usuario);
        return "admin";
    }

    //Esta funcion nos permite registrar usuarios y luego de registro redirecciona a la ruta de admin
    @PostMapping("/register")
    public String guardarUsuario(Usuario usuario, SessionStatus status) {

        usuario.setClave(servicioUsuario.cifrarClave(usuario.getClave()));
        servicioUsuario.guardar(usuario);
        status.setComplete();
        return "redirect:/admin";
    }

    //Esta funcion nos permite editar los usuarios ya ingresados
    @GetMapping("/editaruser/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = servicioUsuario.getID(id);
        model.addAttribute("usuario", usuario);
        return "moduser";
=======
    private UserService service;


    @GetMapping("/registrar")
    public String showRegistrationForm(Model model) {
        List<Rol> listRoles = service.listRoles();
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", listRoles);
        return "registrar";
    }

    @PostMapping("/guardar")
    public String saveUser(User user) {
        service.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "admin";
    }

    @GetMapping("/editaruser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        Optional<User> user = service.getID(id);
        List<Rol> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "modusuario";
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/Controller/ControladorAdmin.java
    }

    //esta funcion nos permite borrar usuario registrados
    @GetMapping("/eliminaruser/{id}")
    public String delete(@PathVariable Long id) {
<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Controlador/ControladorAdmin.java
        servicioUsuario.delete(id);
=======
        service.delete(id);
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/Controller/ControladorAdmin.java
        return "redirect:/admin";
    }
}
