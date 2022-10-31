package com.example.ProyectoInma.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoInma.Modelo.Usuario;

import java.util.Optional;


@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);
}
