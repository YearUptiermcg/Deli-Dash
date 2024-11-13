package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;

    public Order() {
        sandwiches = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
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
