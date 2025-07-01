package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Provincia")
@Setter
@Getter
public class Province extends Base {
    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Country country;
    //Getter y setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
