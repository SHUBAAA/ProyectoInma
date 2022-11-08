package com.example.ProyectoInma.Repository;

import com.example.ProyectoInma.Model.ProductoBoleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProductoBoleta extends JpaRepository<ProductoBoleta, Integer> {

}
