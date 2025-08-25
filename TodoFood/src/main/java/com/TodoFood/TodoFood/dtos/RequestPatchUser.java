package com.TodoFood.TodoFood.dtos;

import com.TodoFood.TodoFood.Entities.Address;
import com.TodoFood.TodoFood.Entities.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@AllArgsConstructor
@NoArgsConstructor

public class RequestPatchUser {
    private String name;
    private String lastname;
    private String email;
    private Rol role;
    private String phone;
    private Address address;
    private String username;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Rol getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
