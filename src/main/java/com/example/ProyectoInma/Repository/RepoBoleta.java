package com.example.ProyectoInma.Repository;


import com.example.ProyectoInma.Model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoBoleta extends JpaRepository<Boleta,Integer> {

}
