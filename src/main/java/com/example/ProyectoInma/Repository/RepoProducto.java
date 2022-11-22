package com.example.ProyectoInma.Repository;


import com.example.ProyectoInma.Model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProducto extends JpaRepository<Producto, Integer> {

}
