package com.example.alienware.projectpizza.Objects;

import java.util.List;

/**
 * Created by michael on 26/11/2016.
 */

public class Order {

    List<Pizza> pizzasToOrder;


    public Order(List<Pizza> pizzasToOrder) {
        this.pizzasToOrder = pizzasToOrder;
    }
}
