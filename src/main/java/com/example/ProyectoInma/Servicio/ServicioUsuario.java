package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Modelo.Usuario;
import com.example.ProyectoInma.Repositorio.RepositorioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServicioUsuario {

    //se llama al repositorio de usuario
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    //Esta funcion lista usuarios
    public List<Usuario> listar() {
        return (List<Usuario>) repositorioUsuario.findAll();
    }

    //esta funcion nos permite encontrar usuario mediante su id
    public Optional<Usuario> getID(Long id) {
        return repositorioUsuario.findById(id);
    }

    //esta funcion nos permite guardad en la base de datos al usuario que se cree
    public void guardar(Usuario u) {
        repositorioUsuario.save(u);
    }
    //esta funcion permite borrar usuarios de la base de datos
    public void delete(Long id) {
        repositorioUsuario.deleteById(id);
    }

    //esta funcion encripta la contraseña por motivos de seguridad
    public String cifrarClave(String clave) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(clave);
    }

}
