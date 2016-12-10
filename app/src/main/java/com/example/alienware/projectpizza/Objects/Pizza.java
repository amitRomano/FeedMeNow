package com.example.alienware.projectpizza.Objects;

import com.example.alienware.projectpizza.R;
import com.google.common.collect.ImmutableMap;

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
    private Set<Topping> topLeftQuart;
    private Set<Topping> topRightQuart;
    private Set<Topping> bottomLeftQuart;
    private Set<Topping> bottomRightQuart;

    public final Map<Quarter,Set<Topping>> quarterMap;
            //ImmutableMap.of(Quarter.topLeftQuart, top)

    public Pizza() {
        topLeftQuart = new HashSet<>();
        topRightQuart = new HashSet<>();
        bottomLeftQuart = new HashSet<>();
        bottomRightQuart = new HashSet<>();

        quarterMap = ImmutableMap.of(Quarter.topLeftQuart, topLeftQuart ,
              Quarter.topRightQuart, topRightQuart ,
              Quarter.bottomLeftQuart, bottomLeftQuart,
              Quarter.bottomRightQuart, bottomRightQuart
                );
    }




    public void insertTopping(Quarter quarter, Topping topping){
                quarterMap.get(quarter).add(topping);
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
