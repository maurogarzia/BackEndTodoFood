package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_producto")
@Setter
@Getter
public class ProductsDetails extends Base{
    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "precio_id")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "tamanio_id")
    private Size size;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Image image;

    // Setters y Getters

    public Integer getStock() {
        return stock;
    }

    public Price getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public Image getImage() {
        return image;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
