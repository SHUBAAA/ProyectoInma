package com.example.ProyectoInma.config;


import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import com.example.ProyectoInma.Repository.RepoRol;
import com.example.ProyectoInma.Repository.UserRepository;
import com.example.ProyectoInma.Servicio.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
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

import java.util.Collections;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
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
                .antMatchers("/admin", "/registrar", "/delete/**", "/edit/**", "/", "/main", "/caja").hasAnyAuthority("ADMIN")
                .antMatchers("/", "/main").hasAnyAuthority("BODEGA")
                .antMatchers("/caja").hasAnyAuthority("CAJERO")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .usernameParameter("email")
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
