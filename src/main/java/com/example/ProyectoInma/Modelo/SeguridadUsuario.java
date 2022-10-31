package com.example.ProyectoInma.Modelo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class SeguridadUsuario implements UserDetails {

    private Usuario user;

    public SeguridadUsuario(Usuario user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getNombre();
    }

    @Override
    public String getPassword() {
        return user.getClave();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user
                        .getRoles()
                        .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
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
