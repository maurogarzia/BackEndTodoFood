package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "detalle_promocion")
public class PromotionDetails extends Base{

    @Column(name = "descuento")
    private Float discount;

    @OneToOne
    @JoinColumn (name = "promocion_id")
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "precio_id")
    private Price price;

    @ManyToMany
    @JoinTable(
            name = "detallePromotion_detalleProducto",
            joinColumns = @JoinColumn(name = "detallePromocion_id"),
            inverseJoinColumns = @JoinColumn(name = "productoDetalle_id")
    )
    private List<ProductsDetails> productsDetails;

    // Getters

    public Promotion getPromotion() {
        return promotion;
    }

    public Price getPrice() {
        return price;
    }

    public Float getDiscount() {
        return discount;
    }

    public List<ProductsDetails> getProductsDetails() {
        return productsDetails;
    }

    // Setters

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public void setProductsDetails(List<ProductsDetails> productsDetails) {
        this.productsDetails = productsDetails;
    }
}
