package com.nhnacademy;

import java.util.ArrayList;

public class BuyList {
    public final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public static class Item {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public String[] getName() {
        String[] itemName = new String[100];
        for (int i = 0; i < items.size(); i++) {
            itemName[i] = items.get(i).name;
        }
        return itemName;
    }

    public int[] getAmount() {
        int[] itemAmount = new int[100];
        for (int i = 0; i < items.size(); i++) {
            itemAmount[i] = items.get(i).amount;
        }
        return itemAmount;
    }
}
