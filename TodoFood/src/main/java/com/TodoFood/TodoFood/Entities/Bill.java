package com.TodoFood.TodoFood.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Factura")
@Setter
@Getter
public class Bill extends Base{
    @Column(name = "total")
    private Double total;
    @Column(name = "fecha_compra")
    private LocalDate datePurchase;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    //Datos de usuario no registrado
    @Column(name = "nombre_comprador")
    private String buyerName;

    @Column(name = "dni_comprador")
    private String buyerDni;

    @Column(name = "direccion_comprador")
    private String buyerAddress;

    @Column(name = "descuento_total")
    private Double totalDiscount;

    @Column(name = "preference_id")
    private String preferenceId;

    @Column(name = "confirmada")
    private Boolean confirmed;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BillDetails> details;

    //Getters y Setters

    public Double getTotal() {
        return total;
    }

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public User getUser() {
        return user;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerDni() {
        return buyerDni;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public List<BillDetails> getDetails() {
        return details;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setBuyerDni(String buyerDni) {
        this.buyerDni = buyerDni;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setDetails(List<BillDetails> details) {
        this.details = details;
    }
}
