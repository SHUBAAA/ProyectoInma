package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Modelo.SeguridadUsuario;
import com.example.ProyectoInma.Repositorio.RepositorioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioUsuario usuarioRepository;

    // Busca si el usuario está registrado
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        return usuarioRepository
                .findByNombre(nombre)
                .map(SeguridadUsuario::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombre));
    }
}