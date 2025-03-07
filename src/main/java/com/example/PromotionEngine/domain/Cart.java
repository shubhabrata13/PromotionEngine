package com.example.PromotionEngine.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> items;
    private Map<String, Integer> remainingItems;

    public Cart() {
        this.items = new HashMap<>();
        this.remainingItems = new HashMap<>();
    }

    public void addItem(String sku, int quantity) {

        items.put(sku, items.getOrDefault(sku, 0) + quantity);
    }

    public int getItemCount(String sku) {

        return items.getOrDefault(sku, 0);
    }

    public Map<String, Integer> getItems() {

        return items;
    }

    public void removeItems(String sku) {
        items.remove(sku);
    }
    public void addRemainingItem(String sku, int quantity) {
        remainingItems.put(sku, remainingItems.getOrDefault(sku, 0) + quantity);
    }

    public int getRemainingItemCount(String sku) {

        return remainingItems.getOrDefault(sku, 0);
    }

    public Map<String, Integer> getRemainingItems() {

        return remainingItems;
    }
}
