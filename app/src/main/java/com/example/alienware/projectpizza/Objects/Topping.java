package com.example.alienware.projectpizza.Objects;

/**
 * Created by Alienware on 11/22/2015.
 */
public enum Topping {
    olives,
    anchovi,
    tomatoes,
    extraCheese,
    tuna,
    mushrooms,
    bacon;

    String imgSrc;


    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}

