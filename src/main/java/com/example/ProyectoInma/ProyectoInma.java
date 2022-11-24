package com.example.ProyectoInma;


<<<<<<< HEAD

import com.example.ProyectoInma.Modelo.Usuario;
import com.example.ProyectoInma.Repositorio.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
=======
>>>>>>> ayuda
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ProyectoInma {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoInma.class, args);
    }

<<<<<<< HEAD
	@Bean
	CommandLineRunner commandLineRunner(RepositorioUsuario usuarios, PasswordEncoder encoder) {
		return args -> {

			//aqui se crea el primer usuario, en este caso el admin, para poder iniciar sesion en el programa
			usuarios.save(new Usuario("a", encoder.encode("a"), "ADMIN","11.222.333-4","ottito@gmail.com"));

		};
	}
=======
>>>>>>> ayuda

}
