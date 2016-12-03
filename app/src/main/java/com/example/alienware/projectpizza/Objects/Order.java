package com.example.alienware.projectpizza.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 26/11/2016.
 */

public class Order {

    List<Pizza> pizzasToOrder;
    List<Drink> drinks;

    public Order() {
        pizzasToOrder = new ArrayList<>();
        drinks = new ArrayList<>();
    }
    public void insertPizza(Pizza p){
        pizzasToOrder.add(p);
    }

    public void insertDrink(Drink drink){
        drinks.add(drink);
    }


}
