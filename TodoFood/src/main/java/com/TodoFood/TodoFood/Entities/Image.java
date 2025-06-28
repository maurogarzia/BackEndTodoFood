package com.TodoFood.TodoFood.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Imagen")
@Setter
@Getter
public class Image extends Base{
    @Column(name = "url")
    private String url;
    @Column(name = "public_id")
    private String publicId;

    //Getter y setter

    public String getUrl() {
        return url;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
}
