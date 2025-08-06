package com.TodoFood.TodoFood.Entities;

import com.TodoFood.TodoFood.Entities.enums.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario")

public class User extends Base{
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastname;

    @NotBlank
    @Column(nullable = false, unique = true,name = "nombre_usuario")
    private String userName;

    @NotBlank
    @Column(nullable = false, name = "contrasenia")
    private String password;

    @Column(name = "rol")
    private Rol Rol;

    @Column(name = "email")
    private String email;

    @JoinColumn(name = "direccion_id")
    private Address address;

    //Getter y setter

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return Rol;
    }

    public String getEmail() {
        return email;
    }


    public Address getAddress() {
        return address;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Rol rol) {
        Rol = rol;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.userName = username;
    }
}
