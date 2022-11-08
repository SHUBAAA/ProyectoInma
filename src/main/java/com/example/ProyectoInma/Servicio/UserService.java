package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Repository.RepoRol;
import com.example.ProyectoInma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    RepoRol roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void registerDefaultUser(User user) {
        Rol roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        encodePassword(user);
        userRepo.save(user);
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    public List<Rol> listRoles() {
        return roleRepo.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

}
