package com.example.amoto;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;
    private String description;
    private int imageResource;
    private int quantity;

    // Constructor, getters y setters
    public Product(String name, double price, String description, int imageResource) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageResource = imageResource;
        this.quantity = 0;
    }

    // Getters y setters para quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Métodos getters faltantes
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    // Método getter para price
    public double getPrice() {
        return price;
    }

    // Otros getters y setters si es necesario
}
