package com.example.PromotionEngine.promo;

import com.example.PromotionEngine.domain.Cart;

public class BulkPromo implements Promo{
    private String sku;
    private int quantity;
    private double price;

    public BulkPromo(String sku, int quantity, double price) {
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public double applyPromotion(Cart cart) {
        int count = cart.getItemCount(sku);
        int applicableBundles = count / quantity;
        if(count>0) {
            cart.addRemainingItem(sku, count - (applicableBundles*quantity));
        }
        return applicableBundles * price;
    }
}
