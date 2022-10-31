package com.example.ProyectoInma.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoInma.Modelo.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Integer> {
}
