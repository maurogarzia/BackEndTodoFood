package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    //Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
