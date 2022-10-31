package com.example.ProyectoInma.Repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoInma.Modelo.Producto;

@Repository
public interface RepositorioProducto extends CrudRepository<Producto, Integer> {
}
