package com.example.ProyectoInma;

import com.example.ProyectoInma.Model.User;

import com.example.ProyectoInma.Repository.UserRepository;
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
	CommandLineRunner commandLineRunner(UserRepository usuarios, PasswordEncoder encoder) {
		return args -> {


			usuarios.save(new User("a", encoder.encode("a"), "ADMIN","11.222.333-4","ottito@gmail.com"));

		};
	}

}