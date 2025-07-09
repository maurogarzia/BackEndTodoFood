package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Productos")


public class Products extends Base {

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category category;

    //Getters y Setters

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
