package com.nhnacademy;

public class Food {
    private final String name;
    private final int price;
    int foodCount;

    public Food(String name, int price, int foodCount) {
        this.name = name;
        this.price = price;
        this.foodCount = foodCount;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return price;
    }

    public int getFoodCount() {
        return foodCount;
    }


    @Override // 오버라이드 왜 한지 모르겠음
    public String toString() {
        return name + '(' + price + "원) " + foodCount + '개';
    }
}
