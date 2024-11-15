package com.pluralsight.order;

// Import the Sandwich class from the food package
import com.pluralsight.food.Sandwich;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;

    public Order() {
        sandwiches = new ArrayList<>();
    }

    public void addSandwich(String size, String breadType, double price, List<String> regularToppings, List<String> premiumToppings, boolean toasted) {
        Sandwich newSandwich = new Sandwich(size, breadType, price, regularToppings, premiumToppings, toasted);
        sandwiches.add(newSandwich);
    }

    public void printOrderDetails() {
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
    }

    public double getTotalPrice() {
        return sandwiches.stream().mapToDouble(Sandwich::getPrice).sum();
    }
}