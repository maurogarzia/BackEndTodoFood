package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_producto")

public class ProductsDetails extends Base{
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "tamanio_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "imagen_id")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Products product;

    // Setters y Getters

    public Integer getStock() {
        return stock;
    }

    public Float getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public Image getImage() {
        return image;
    }

    public Products getProduct() {
        return product;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
