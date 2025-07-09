package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Promocion")

public class Promotion extends Base{
    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha_inicio")
    private LocalDate initDate;
    @Column(name = "fecha_final")
    private LocalDate finallyDate;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "descuento_aplicado")
    private Float discount;

    @OneToOne
    @JoinColumn(name = "precio_promocional") // Precio que se calculara
    private Price price;

    @ManyToMany
    @JoinTable(
            name = "promocion_detalleProducto",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "detalleProducto_id")
    )
    private List<ProductsDetails> details;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Image image;

    //Setters y Getters


    public LocalDate getInitDate() {
        return initDate;
    }

    public LocalDate getFinallyDate() {
        return finallyDate;
    }

    public String getDescription() {
        return description;
    }

    public Float getDiscount() {
        return discount;
    }

    public Price getPrice() {
        return price;
    }

    public List<ProductsDetails> getDetails() {
        return details;
    }

    public Image getImage() {
        return image;
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

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setDetails(List<ProductsDetails> details) {
        this.details = details;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    //Metodo para calcular el precio
    public void calculatePricePromotinal() {

        Float totalPurchasePrice = 0.0f;
        Float totalSalesPrice = 0.0f;

        for (ProductsDetails detail : details){
            totalPurchasePrice += detail.getPrice().getPurchasePrice();
            totalSalesPrice += detail.getPrice().getSalesPrice();
        }

        Float discountedPrice = totalSalesPrice * (1 - discount / 100);
        Price promotionalPrice = new Price();
        promotionalPrice.setPurchasePrice(totalPurchasePrice);
        promotionalPrice.setSalesPrice(discountedPrice);

        this.price = promotionalPrice;
    }

}
