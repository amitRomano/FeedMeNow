package com.example.alienware.projectpizza.Objects;

/**
 * Created by user on 26/11/2015.
 */
public class Drink {

    int drinkId;
    String srcImage;

    public Drink(int drinkId, String srcImage) {
        this.drinkId = drinkId;
        this.srcImage = srcImage;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }
}
