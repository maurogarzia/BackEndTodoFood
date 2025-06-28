package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Localidad")
@Setter
@Getter
public class Locality extends Base{
    @Column(name = "nombre")
    private String name;
    @Column(name = "codigo_postal")
    private Integer cp;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    //Getter y setter

    public String getName() {
        return name;
    }

    public Integer getCp() {
        return cp;
    }

    public Province getProvince() {
        return province;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
