package com.example.PromotionEngine.domain;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private static final Map<String, Double> productPrices = new HashMap<>();

    static {
        productPrices.put("A", 50.0);
        productPrices.put("B", 30.0);
        productPrices.put("C", 20.0);
        productPrices.put("D", 15.0);
    }

    public static double getProductPrice(String sku) {
        return productPrices.getOrDefault(sku, 0.0);
    }
}

