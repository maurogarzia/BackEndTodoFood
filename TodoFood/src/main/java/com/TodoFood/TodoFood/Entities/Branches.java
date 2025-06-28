package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sucursales")
@Setter
@Getter
public class Branches extends Base {
    @JoinColumn(name = "direccion_id")
    private Address address;

    //Getters Y setters

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
