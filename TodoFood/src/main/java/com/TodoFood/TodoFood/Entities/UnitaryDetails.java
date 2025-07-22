package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles_unitarios")

public class UnitaryDetails extends Base{
    @Column(name = "cantidad")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "detalles_productos_id")
    private ProductsDetails productDetails;

    // Getters

    public Integer getQuantity() {
        return quantity;
    }

    public ProductsDetails getProductDetails() {
        return productDetails;
    }

    // Setters


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductDetails(ProductsDetails productDetails) {
        this.productDetails = productDetails;
    }
}
