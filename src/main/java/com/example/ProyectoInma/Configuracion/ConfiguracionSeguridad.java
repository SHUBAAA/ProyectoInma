package com.example.ProyectoInma.Configuracion;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ProyectoInma.Servicio.JpaUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfiguracionSeguridad {
    //aqui se llama al servicio
    private final JpaUserDetailsService jpaUserDetailsService;
    //aqui se encarga del autenticar el inicio de sesion
    public ConfiguracionSeguridad(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    // Filtro de seguridad
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // No permite solicitudes a menos que el usuario esté registrado
                .authorizeRequests(consulta -> consulta
                        // Se añaden excepciones en mvc matchers, donde se podrá ingresar sin autenticación
                        .mvcMatchers().permitAll()
                        .anyRequest().authenticated())
                // Así spring security identifica como obtener los datos de los usuarios
                .userDetailsService(jpaUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                // Autenticación básica HTTP, puede ser así (logeo básico) o un form de inicio de sesión
                .formLogin((formulario) -> formulario
                        // permite acceso a todos
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((cerrarSesion) -> cerrarSesion.permitAll())
                .build();
    }

    //Cifrar contraseña
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
