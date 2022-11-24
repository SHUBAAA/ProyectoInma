package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Repository.RepoRol;
import com.example.ProyectoInma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    RepoRol roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<User> listAll() {
        return userRepo.findAll();
    }

    public Optional<User> getID(Long id) {
        return userRepo.findById(id);
    }

    public List<Rol> listRoles() {
        return roleRepo.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }
    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }



}
