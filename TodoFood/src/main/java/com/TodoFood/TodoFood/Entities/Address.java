package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Direccion")

public class Address extends Base {
    @Column(name = "calle")
    private String street;
    @Column(name = "numero")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Locality locality;

    //Getters y setters

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
