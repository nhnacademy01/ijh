package com.nhnacademy;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Food> foods = new ArrayList<>();

    public void add(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }
}
