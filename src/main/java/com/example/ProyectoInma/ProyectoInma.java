package com.example.ProyectoInma;



import com.example.ProyectoInma.Modelo.Usuario;
import com.example.ProyectoInma.Repositorio.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProyectoInma {
	public static void main(String[] args) {
		SpringApplication.run(ProyectoInma.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(RepositorioUsuario usuarios, PasswordEncoder encoder) {
		return args -> {

			//aqui se crea el primer usuario, en este caso el admin, para poder iniciar sesion en el programa
			usuarios.save(new Usuario("a", encoder.encode("a"), "ADMIN","11.222.333-4","ottito@gmail.com"));

		};
	}

}
