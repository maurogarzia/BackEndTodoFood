package com.TodoFood.TodoFood.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle_Factura")
@Setter
@Getter
public class BillDetails extends Base {
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Products product;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_unitario")
    private Double unitPrice;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "descuento")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonBackReference
    private Bill bill;

    // Getters y Setters

    public Products getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
