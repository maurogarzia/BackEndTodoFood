package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Tamanio")

public class Size extends Base{
    @Column(name = "nombre")
    private String name;

    //Getter y setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
