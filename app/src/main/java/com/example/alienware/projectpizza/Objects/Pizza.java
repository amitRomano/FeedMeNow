package com.example.alienware.projectpizza.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by michael on 26/11/2016.
 */

public class Pizza {
    private static final int topLeft = 0 ;
    private static final int topRight = 1;
    private static final int bottomLeft = 2;
    private static final int bottomRight = 3;
    Set<Topping> topLeftQuart;
    Set<Topping> topRightQuart;
    Set<Topping> bottomLeftQuart;
    Set<Topping> bottomRightQuart;

    public Pizza() {
    }

    public Pizza(Set<Topping> topLeftQuart, Set<Topping> topRightQuart, Set<Topping> bottomLeftQuart, Set<Topping> bottomRightQuart) {
        this.topLeftQuart = topLeftQuart;
        this.topRightQuart = topRightQuart;
        this.bottomLeftQuart = bottomLeftQuart;
        this.bottomRightQuart = bottomRightQuart;
    }

    public void insertTopping(int quarter, Topping topping){
        switch (quarter){
            case topLeft:
                topLeftQuart.add(topping);
                break;
            case topRight:
                topRightQuart.add(topping);
                break;
            case bottomRight:
                bottomRightQuart.add(topping);
                break;
            case bottomLeft:
                bottomLeftQuart.add(topping);
                break;
            default:
                throw new IllegalArgumentException("the argument of quarter is not valid :" + quarter);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (topLeftQuart != null ? !topLeftQuart.equals(pizza.topLeftQuart) : pizza.topLeftQuart != null)
            return false;
        if (topRightQuart != null ? !topRightQuart.equals(pizza.topRightQuart) : pizza.topRightQuart != null)
            return false;
        if (bottomLeftQuart != null ? !bottomLeftQuart.equals(pizza.bottomLeftQuart) : pizza.bottomLeftQuart != null)
            return false;
        return bottomRightQuart != null ? bottomRightQuart.equals(pizza.bottomRightQuart) : pizza.bottomRightQuart == null;

    }

    @Override
    public int hashCode() {
        int result = topLeftQuart != null ? topLeftQuart.hashCode() : 0;
        result = 31 * result + (topRightQuart != null ? topRightQuart.hashCode() : 0);
        result = 31 * result + (bottomLeftQuart != null ? bottomLeftQuart.hashCode() : 0);
        result = 31 * result + (bottomRightQuart != null ? bottomRightQuart.hashCode() : 0);
        return result;
    }
}
