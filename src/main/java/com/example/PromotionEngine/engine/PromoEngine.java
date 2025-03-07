package com.example.PromotionEngine.engine;

import com.example.PromotionEngine.domain.Cart;
import com.example.PromotionEngine.domain.ProductCatalog;
import com.example.PromotionEngine.promo.Promo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PromoEngine {
    private List<Promo> promotions;

    public PromoEngine(List<Promo> promotions) {

        this.promotions = promotions;
    }


    public double calculateTotal(Cart cart) {
        double total = promotions.stream()
                .mapToDouble(promotion -> promotion.applyPromotion(cart))
                .sum();

        total += cart.getRemainingItems().entrySet().stream()
                .mapToDouble(entry -> entry.getValue() * ProductCatalog.getProductPrice(entry.getKey()))
                .sum();

        return total;
    }

}

