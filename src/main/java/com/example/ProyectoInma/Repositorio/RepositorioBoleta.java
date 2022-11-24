package com.example.ProyectoInma.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ProyectoInma.Modelo.Boleta;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioBoleta extends JpaRepository<Boleta,Integer> {
}
