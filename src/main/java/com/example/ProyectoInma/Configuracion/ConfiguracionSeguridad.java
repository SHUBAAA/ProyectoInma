package com.example.ProyectoInma.Configuracion;



<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Configuracion/ConfiguracionSeguridad.java
=======
import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Repository.RepoRol;
import com.example.ProyectoInma.Repository.UserRepository;
import com.example.ProyectoInma.Servicio.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/config/SecurityConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Configuracion/ConfiguracionSeguridad.java
import com.example.ProyectoInma.Servicio.JpaUserDetailsService;
=======
import java.util.Collections;
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/config/SecurityConfig.java


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Configuracion/ConfiguracionSeguridad.java
public class ConfiguracionSeguridad {
    //aqui se llama al servicio
    private final JpaUserDetailsService jpaUserDetailsService;
    //aqui se encarga del autenticar el inicio de sesion
    public ConfiguracionSeguridad(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
=======
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/config/SecurityConfig.java
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/main").hasAnyAuthority("BODEGA", "ADMIN")
                .antMatchers("/caja").hasAnyAuthority("ADMIN", "CAJERO")
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .antMatchers("/registrar").hasAuthority("ADMIN")
                .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
                .antMatchers("/delete/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }


    @Bean
    CommandLineRunner commandLineRunner(RepoRol roles, UserRepository usuarios, PasswordEncoder encoder) {
        return args -> {
            roles.save(new Rol("ADMIN"));
            roles.save(new Rol("CAJERO"));
            roles.save(new Rol("BODEGA"));
            usuarios.save(new User("manolo@gmail.com", encoder.encode("a"), "11.222.333-4", "Manolo", Collections.singletonList(roles.findById(1).get())));

        };


    }

}
