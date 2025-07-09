package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Precio")

public class Price extends Base{
    @Column(name = "precio_venta")
    private Float salesPrice;
    @Column(name = "precioCompra")
    private Float purchasePrice;

    //Getters y Setters


    public Float getSalesPrice() {
        return salesPrice;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setSalesPrice(Float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
