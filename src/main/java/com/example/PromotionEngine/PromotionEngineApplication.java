package com.example.PromotionEngine;

import com.example.PromotionEngine.promo.BulkPromo;
import com.example.PromotionEngine.promo.BundlePromo;
import com.example.PromotionEngine.domain.Cart;
import com.example.PromotionEngine.promo.Promo;
import com.example.PromotionEngine.engine.PromoEngine;

import java.util.Arrays;

//@SpringBootApplication
public class PromotionEngineApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PromotionEngineApplication.class, args);
        PromotionEngineApplication promoEngine = new PromotionEngineApplication();
        promoEngine.scenarioA();
        promoEngine.scenarioB();
        promoEngine.scenarioC();

    }

    public void scenarioA(){
        Cart cart = new Cart();
        cart.addItem("A", 1);
        cart.addItem("B", 1);
        cart.addItem("C", 1);
        System.out.println("Total Order Value for scenarioA: " + calculatePromo(cart));
    }

    public void scenarioB(){
        Cart cart = new Cart();
        cart.addItem("A", 5);
        cart.addItem("B", 5);
        cart.addItem("C", 1);
        System.out.println("Total Order Value for scenarioB: " + calculatePromo(cart));
    }

    public void scenarioC(){
        Cart cart = new Cart();
        cart.addItem("A", 3);
        cart.addItem("B", 5);
        cart.addItem("C", 1);
        cart.addItem("D", 1);
        System.out.println("Total Order Value for scenarioC: " + calculatePromo(cart));
    }

    public double calculatePromo(Cart cart){
        Promo bulkA = new BulkPromo("A", 3, 130);
        Promo bulkB = new BulkPromo("B", 2, 45);
        Promo bundleCD = new BundlePromo("C", "D", 30);
        PromoEngine engine = new PromoEngine(Arrays.asList(bulkA, bulkB, bundleCD));

        return engine.calculateTotal(cart);
    }

}
