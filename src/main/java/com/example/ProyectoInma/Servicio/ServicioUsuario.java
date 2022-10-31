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

    @Autowired
    private RepositorioUsuario dataUser;

    public List<Usuario> listar() {
        return (List<Usuario>) dataUser.findAll();
    }


    public Optional<Usuario> getID(Long id) {
        return dataUser.findById(id);
    }


    public void guardar(Usuario u) {
        dataUser.save(u);
    }

    public void delete(Long id) {
        dataUser.deleteById(id);
    }


    public String cifrarClave(String clave) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(clave);
    }

}
