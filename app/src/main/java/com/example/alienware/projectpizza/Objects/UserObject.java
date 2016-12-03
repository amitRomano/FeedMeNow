package com.example.alienware.projectpizza.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 26/11/2015.
 */

/*
the user object as described below .. including the session itself
 */
public class UserObject implements Serializable {

    private static UserObject currentUserObject = new UserObject(); // this is the currentUserObject which we are using in this contex

    String name;
    String phone;
    List <City> address;
    List <Drink> drinkUserLike;
    List <PizzaPlace> pizzaPlaceUserDontLike;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<City> getAddress() {
        return address;
    }

    public void setAddress(List<City> address) {
        this.address = address;
    }

    public List<Drink> getDrinkUserLike() {
        return drinkUserLike;
    }

    public void setDrinkUserLike(List<Drink> drinkUserLike) {
        this.drinkUserLike = drinkUserLike;
    }

    public List<PizzaPlace> getPizzaPlaceUserDontLike() {
        return pizzaPlaceUserDontLike;
    }

    public void setPizzaPlaceUserDontLike(List<PizzaPlace> pizzaPlaceUserDontLike) {
        this.pizzaPlaceUserDontLike = pizzaPlaceUserDontLike;
    }

    public UserObject() {
        this.address = new ArrayList<>();
        this.drinkUserLike = new ArrayList<>();
        this.pizzaPlaceUserDontLike = new ArrayList<>();
    }

    public UserObject(String name, String phone, List<City> address, List<Drink> drinkUserLike, List<PizzaPlace> pizzaPlaceUserDontLike) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.drinkUserLike = drinkUserLike;
        this.pizzaPlaceUserDontLike = pizzaPlaceUserDontLike;
    }

    public static UserObject getCurrentUserObject() {
        return currentUserObject;
    }

    public static void setCurrentUserObject(UserObject currentUserObject) {
        UserObject.currentUserObject = currentUserObject;
    }
}
