package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Promocion")

public class Promotion extends Base{

    // Atributos Principales de las promociones

    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha_inicio")
    private LocalDate initDate;
    @Column(name = "fecha_final")
    private LocalDate finallyDate;
    @Column(name = "descripcion")
    private String description;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Image image;

    // Getters

    public String getName() {
        return name;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public LocalDate getFinallyDate() {
        return finallyDate;
    }

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public void setFinallyDate(LocalDate finallyDate) {
        this.finallyDate = finallyDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
