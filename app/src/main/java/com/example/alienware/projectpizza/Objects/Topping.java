package com.example.alienware.projectpizza.Objects;

/**
 * Created by Alienware on 11/22/2015.
 */
public enum Topping {
    olives("olive.img.src"),
    anchovi("anchovi.img.src"),
    tomatoes("tomatoes.img.src"),
    extraCheese("cheese.img.src"),
    mushrooms("mushrooms.img.src"),
    bacon("bacon.img.src"),
    onion("onion.img.src"),
    tuna("tuna.img.src"),
    pineapple("pineapple.img.src"),
    beef("beef.img.src"),
    corn("corn.img.src"),
    peperroni("peperroni.img.src"),
    blueCheese("bluecheese.img.src");


    private final String imgSrc;

    Topping(String imgSrc){
        this.imgSrc = imgSrc;
    }

}

