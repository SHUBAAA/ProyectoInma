package com.example.ProyectoInma;


import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Repository.RepoRol;
import com.example.ProyectoInma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

//DataSQL en resources
@SpringBootApplication
public class ProyectoInma {

    @Autowired
    RepoRol roleRepo;
    public static void main(String[] args) {
        SpringApplication.run(ProyectoInma.class, args);
    }


}
