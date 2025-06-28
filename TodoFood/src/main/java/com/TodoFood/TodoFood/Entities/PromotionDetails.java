package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Detalle_Promocion")
@Setter
@Getter
public class PromotionDetails extends Base{
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
            name = "promocion_producto",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Products> products;

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

    public List<Products> getProducts() {
        return products;
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

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    //Metodo para calcular el precio
    public void calculatePricePromotinal() {
        Float totalPurchasePrice = 0.0f;
        Float totalSalesPrice = 0.0f;

        for (Products product : products){
            totalPurchasePrice += product.getDetails().getPrice().getPurchasePrice();
            totalSalesPrice += product.getDetails().getPrice().getSalesPrice();
        }

        Float discountedPrice = totalSalesPrice * (1 - discount / 100);
        Price promotionalPrice = new Price();
        promotionalPrice.setPurchasePrice(totalPurchasePrice);
        promotionalPrice.setSalesPrice(discountedPrice);

        this.price = promotionalPrice;
    }

}
