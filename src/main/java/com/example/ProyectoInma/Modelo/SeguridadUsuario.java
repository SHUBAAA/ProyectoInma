<<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Modelo/SeguridadUsuario.java
package com.example.ProyectoInma.Modelo;
========
package com.example.ProyectoInma.Servicio;
>>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/Servicio/CustomUserDetails.java

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.example.ProyectoInma.Model.Rol;
import com.example.ProyectoInma.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<<< HEAD:src/main/java/com/example/ProyectoInma/Modelo/SeguridadUsuario.java
import java.util.Arrays;
import java.util.Collection;

public class SeguridadUsuario implements UserDetails {

    private Usuario user;

    public SeguridadUsuario(Usuario user) {
========
public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private User user;

    public CustomUserDetails(User user) {
>>>>>>>> ayuda:src/main/java/com/example/ProyectoInma/Servicio/CustomUserDetails.java
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Rol> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Rol role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }


    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}