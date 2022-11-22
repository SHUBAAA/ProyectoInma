package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Repository.RepoRol;
import com.example.ProyectoInma.Repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;


import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RepoRol reporol;

    @ParameterizedTest
    @CsvSource({"Admin,email1@gmail.com"})
    @Order(1)
    void UsuarioTieneRol(String nombreRol, String email){
        Rol admin = reporol.save(new Rol(nombreRol));
        User user = new User(email, "a", "11.222.333-4", "Manolo", Collections.singletonList(reporol.findById(1).get()));

        User userAdmin = userRepository.save(user);

        assertNotNull(userAdmin);
        assertThat(userAdmin.getRoles().get(0)).isEqualTo(admin);

    }

    @Test
    @Order(2)
    @Rollback(false)
    void getID() {
        User user = new User("aa", "abb", "ab", "abb");
        User usuarioguardado = userRepository.save(user);

        assertThat(usuarioguardado.getId()).isEqualTo(2);
    }


    @Test
    @Order(3)
    @Rollback(false)
    void GuardarUsuarioBaseDeDatos() {

        User user = new User("a", "a", "a", "a");
        User userguardado = userRepository.save(user);

        assertNotNull(userguardado);
        assertThat(userguardado).isEqualTo(user);
    }

    @Test
    @Order(4)
    void ListarUsuarios() {
        List<User> usuarios = userRepository.findAll();
        assertThat(usuarios.size()).isGreaterThan(0);
    }


    @Test
    void BorrarUsuario() {

        boolean existeantes = userRepository.findById(2L).isPresent();

        userRepository.deleteById(2L);

        boolean existeDespues = userRepository.findById(2L).isPresent();

        assertTrue(existeantes);
        assertFalse(existeDespues);
    }

    @Test
    public void testCreacionRoles() {
        Rol user = new Rol("User");
        Rol admin = new Rol("Admin");
        Rol customer = new Rol("Customer");

        reporol.saveAll(List.of(user, admin, customer));

        List<Rol> listRoles = reporol.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }

    @Test
    void encriptacionContrasena() {
        BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
        String contrasena = "holaDeberiaEstarEncriptado";
        String contrasenaEncriptada = encriptador.encode(contrasena);

        assertThat(contrasena).isNotEqualTo(contrasenaEncriptada);
    }
}