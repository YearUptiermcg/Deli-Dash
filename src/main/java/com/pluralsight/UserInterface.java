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
        boolean running = true;
        while (running) {
            System.out.println("Welcome to DELI-cious! Please select an option:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createNewOrder();
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Order screen
    public void createNewOrder() {
        System.out.println("Creating a new order...");

        boolean ordering = true;
        while (ordering) {
            System.out.println("Order Options:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order - return to main menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    selectSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    ordering = false;  // End order process after checkout
                    break;
                case 0:
                    System.out.println("Order canceled. Returning to main menu.");
                    ordering = false;  // End order process
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public void selectSandwich() {
        System.out.println("Let's build your sandwich!");
    }

    // addDrink method
    public void addDrink() {
        System.out.println("Adding a drink...");
    }

    // addChips method
    public void addChips() {
        System.out.println("Adding chips...");
    }

    // Checkout method
    public void checkout() {
        System.out.println("Checking out...");
    }
}
