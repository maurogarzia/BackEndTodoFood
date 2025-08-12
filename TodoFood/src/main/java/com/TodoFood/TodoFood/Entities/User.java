package com.TodoFood.TodoFood.Entities;

import com.TodoFood.TodoFood.Entities.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Usuario")

public class User extends Base{
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastname;
    @Column(name = "telefono")
    private String phone;

    @NotBlank
    @Column(nullable = false, unique = true,name = "nombre_usuario")
    private String username;

    @NotBlank
    @Column(nullable = false, name = "contrasenia")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol Rol;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "direccion_id")
    private Address address;

    //Getter y setter


    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
