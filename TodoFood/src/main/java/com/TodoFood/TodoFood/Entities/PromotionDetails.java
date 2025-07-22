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


    @Column(name = "precio") // Deberia hacer una funcion para que se setee
    private Float price;

    @ManyToMany
    @JoinTable(
            name = "detalles_de_promocion",
            joinColumns = @JoinColumn(name = "detallePromocion_id"),
            inverseJoinColumns = @JoinColumn(name = "detalleUnitario_id")
    )
    private List<UnitaryDetails> unitaryDetails;

    // Getters

    public Promotion getPromotion() {
        return promotion;
    }

    public Float getPrice() {
        return price;
    }

    public Float getDiscount() {
        return discount;
    }

    public List<UnitaryDetails> getUnitaryDetails() {
        return unitaryDetails;
    }

    // Setters

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public void setUnitaryDetails(List<UnitaryDetails> unitaryDetails) {
        this.unitaryDetails = unitaryDetails;
    }

    public void calculatePrice() {
        float totalPrice = 0f;
        for (UnitaryDetails details : unitaryDetails){
            price = details.getProductDetails().getPrice() * details.getQuantity(); // Multiplico el precio del producto por su cantidad
            totalPrice += price; // Se lo sumo al precio total
        }
        float finallyPrice = totalPrice - (totalPrice * (discount / 100)); // Precio final con el descuento
        setPrice(finallyPrice       );
    }
}
