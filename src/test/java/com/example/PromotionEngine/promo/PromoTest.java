package com.example.PromotionEngine.promo;

import com.example.PromotionEngine.domain.Cart;
import com.example.PromotionEngine.engine.PromoEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PromoTest {
    private Cart cart;
    private PromoEngine engine;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        Promo bulkA = new BulkPromo("A", 3, 130);
        Promo bulkB = new BulkPromo("B", 2, 45);
        Promo bundleCD = new BundlePromo("C", "D", 30);
        engine = new PromoEngine(Arrays.asList(bulkA, bulkB, bundleCD));
    }

    @Test
    public void testScenarioA() {
        cart.addItem("A", 1);
        cart.addItem("B", 1);
        cart.addItem("C", 1);

        assertEquals(100, engine.calculateTotal(cart));
    }

    @Test
    public void testScenarioB() {
        cart.addItem("A", 5);
        cart.addItem("B", 5);
        cart.addItem("C", 1);

        assertEquals(370, engine.calculateTotal(cart));
    }

    @Test
    public void testScenarioC() {
        cart.addItem("A", 3);
        cart.addItem("B", 5);
        cart.addItem("C", 1);
        cart.addItem("D", 1);

        assertEquals(280, engine.calculateTotal(cart));
    }

}
