package com.example.amoto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Product implements Serializable {
    private String name;
    private double price;
    private String description;
    private int imageResource;
    private int quantity;


    public Product(String name, double price, String description, int imageResource) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageResource = imageResource;
        this.quantity = 0;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }


    public double getPrice() {
        return price;
    }


    public static double getPriceForProduct(String productName) {

        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Motocicleta 1", 1000.0);
        productPrices.put("Motocicleta 2", 1500.0);
        productPrices.put("Motocicleta 3", 2000.0);
        productPrices.put("Casco 1", 50.0);
        productPrices.put("Casco 2", 75.0);
        productPrices.put("Casco 3", 100.0);
        productPrices.put("neumatico", 25.0);
        productPrices.put("cadena", 50.0);
        productPrices.put("escape", 75.0);


        Double price = productPrices.get(productName);


        return (price != null) ? price : 0.0;
    }


}
