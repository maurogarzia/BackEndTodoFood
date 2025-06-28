package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Promocion")
@Setter
@Getter
public class Promotion extends Base{
    @Column(name = "nombre")
    private String name;

    @OneToOne
    @JoinColumn(name = "detalle_promocion")
    private PromotionDetails promotionDetails;

    //Getters y Setters

    public String getName() {
        return name;
    }

    public PromotionDetails getPromotionDetails() {
        return promotionDetails;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPromotionDetails(PromotionDetails promotionDetails) {
        this.promotionDetails = promotionDetails;
    }
}
