package com.pluralsight;

import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    private double price;
    private List<String> regularToppings;
    private List<String> premiumToppings;
    private boolean toasted;

    public Sandwich(String size, String breadType, double price, List<String> regularToppings, List<String> premiumToppings, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.price = price;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
        this.toasted = toasted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s sandwich on %s bread, toasted: %b, regular toppings: %s, premium toppings: %s, price: $%.2f",
                size, breadType, toasted, regularToppings, premiumToppings, price);
    }
}
