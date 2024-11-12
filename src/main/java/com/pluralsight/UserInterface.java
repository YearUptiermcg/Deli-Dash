package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    // Constructor
    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    // Display the main menu
    public void displayMainMenu() {
        System.out.println("Welcome to DELI-cious! Please select an option:");
        System.out.println("1) New Order");
        System.out.println("0) Exit");

        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Creating a new order...");
            selectSandwich();  // Call the selectSandwich method here
        } else {
            System.out.println("Exiting... Thank you!");
        }
    }

    // Sandwich Selection Method
    public void selectSandwich() {
        System.out.println("Let's build your sandwich!");

        // Select size
        System.out.println("Choose sandwich size (4, 8, or 12 inches):");
        int size = scanner.nextInt();
        double basePrice = 0;

        switch (size) {
            case 4:
                basePrice = 5.50;
                break;
            case 8:
                basePrice = 7.00;
                break;
            case 12:
                basePrice = 8.50;
                break;
            default:
                System.out.println("Invalid size selected, defaulting to 4 inches.");
                size = 4;
                basePrice = 5.50;
        }

        // Select bread type
        System.out.println("Choose bread type (white, wheat, rye, wrap):");
        String breadType = scanner.next();

        // Sandwich object
        Sandwich sandwich = new Sandwich(size + "-inch", breadType, basePrice);

        // Confirmation of Sandwich Selection
        System.out.printf("Sandwich created: %d-inch %s bread, base price: $%.2f%n", size, breadType, basePrice);
    }
}
