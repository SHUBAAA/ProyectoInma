package com.example.ProyectoInma.Repository;

import com.example.ProyectoInma.Model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRol extends JpaRepository<Rol, Integer> {
    // @Query("SELECT r FROM Rol r WHERE r.name = ?1")
    public Rol findByName(String name);

}
