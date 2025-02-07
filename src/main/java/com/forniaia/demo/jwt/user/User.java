package com.forniaia.demo.jwt.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = {"dni"})})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID autogenerado como clave primaria

    @Column(nullable = false, unique = true)
    private String dni;  // DNI como identificador único

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Role role;

//    // Auditoría
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime createdAt;  // Fecha de creación
//
//    @Column
//    private LocalDateTime updatedAt;  // Fecha de la última actualización
//
//    @Column(nullable = false, updatable = false)
//    private String createdBy;  // Usuario que creó el registro
//
//    @Column
//    private String updatedBy;  // Usuario que realizó la última actualización

    // Métodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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

    // Si necesitas el DNI como "username" en Spring Security (autenticación), puedes sobrescribir el método `getUsername`:
    @Override
    public String getUsername() {
        return dni;  // DNI actúa como el identificador para autenticación
    }



}
