package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sucursales")

public class Branches extends Base {
    @Column(name = "nombre")
    private String name;

    @Column(name = "numero_telefonico")
    private Long number;

    @OneToOne
    @JoinColumn(name = "direccion_id")
    private Address address;

    //Getters Y setters

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
