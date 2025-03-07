package com.example.PromotionEngine.domain;

public class Item {
    private String skuNamw;
    private double price;

    public Item(String skuName, double price) {
        this.skuNamw = skuName;
        this.price = price;
    }

    public String getSku() {
        return skuNamw;
    }

    public double getPrice() {
        return price;
    }
}
