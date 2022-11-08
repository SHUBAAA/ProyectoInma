package com.example.ProyectoInma.Controller;



import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Servicio.UserService;
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

    @Autowired
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
    }

    @GetMapping("/eliminaruser/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin";
    }
}
