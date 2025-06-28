package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Productos")
@Setter
@Getter

public class Products extends Base {

    @Column(name = "nombre")
    private String name;

    @JoinColumn(name = "categoria_id")
    private Category category;

    @JoinColumn(name = "detalles")
    private ProductsDetails details;

    //Getters y Setters

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public ProductsDetails getDetails() {
        return details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDetails(ProductsDetails details) {
        this.details = details;
    }
}
