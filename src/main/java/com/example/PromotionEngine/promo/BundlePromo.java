package com.example.PromotionEngine.promo;

import com.example.PromotionEngine.domain.Cart;

public class BundlePromo implements Promo{
    private String sku1;
    private String sku2;
    private double price;

    public BundlePromo(String sku1, String sku2, double price) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.price = price;
    }

    @Override
    public double applyPromotion(Cart cart) {
        int count1 = cart.getItemCount(sku1);
        int count2 = cart.getItemCount(sku2);
        int applicableBundles = Math.min(count1, count2);
        if(applicableBundles>0) {
            cart.addRemainingItem(sku1, 0);
            cart.addRemainingItem(sku2, 0);
        }else{
            cart.addRemainingItem(sku1, count1);
            cart.addRemainingItem(sku2, count2);
        }
        return applicableBundles * price;
    }
}
