package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size; //  "4-inch", "8-inch", "12-inch"
    private String breadType; //  "white", "wheat",
    private double basePrice; // Price based on sandwich size
    private List<Topping> toppings;

    public Sandwich(String size, String breadType, double basePrice) {
        this.size = size;
        this.breadType = breadType;
        this.basePrice = basePrice;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
