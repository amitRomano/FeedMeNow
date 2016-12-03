package com.example.alienware.projectpizza.Objects;

/**
 * Created by Alienware on 11/22/2015.
 */
public class Topping {
    int id;
    String imageSrc;

    public Topping(int id, String imageSrc) {
        this.id = id;
        this.imageSrc = imageSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}

