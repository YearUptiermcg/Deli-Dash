package com.pluralsight;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Display home menu and navigate to order menu
    public void showHomeMenu() {
        while (true) {
            System.out.println("\n=== Home Screen ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> showOrderMenu();
                case 0 -> {
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Display order menu, where user can add items to the order
    public void showOrderMenu() {
        while (true) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order - go back to the home page");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> selectSandwich();
                case 2 -> System.out.println("Drink menu coming soon...");
                case 3 -> System.out.println("Chips menu coming soon...");
                case 4 -> {
                    System.out.println("Checkout screen coming soon...");
                    return; // back to home screen after checkout
                }
                case 0 -> {
                    System.out.println("Order canceled. Returning to home screen.");
                    return; // back to home screen
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Select a sandwich and build it with the user's choices
    public void selectSandwich() {
        System.out.println("\nLet's build your sandwich!");

        // Select sandwich size
        System.out.println("Choose sandwich size (4, 8, or 12 inches):");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume newline
        double basePrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> {
                System.out.println("Invalid size selected, defaulting to 4 inches.");
                yield 5.50;
            }
        };

        System.out.println("You selected a " + size + "-inch sandwich. Base price: $" + df.format(basePrice));

        // Select bread type
        System.out.println("Choose bread type (white, wheat, rye, wrap):");
        String breadType = scanner.nextLine();
        System.out.println("You selected " + breadType + " bread.");

        // Regular toppings
        List<String> regularToppings = new ArrayList<>();
        System.out.println("Select regular toppings (lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms). Type 'done' to finish:");
        while (true) {
            String topping = scanner.nextLine().trim().toLowerCase();
            if (topping.equals("done")) break;

            // Validate and add each topping
            if (topping.matches("lettuce|peppers|onions|tomatoes|jalapenos|cucumbers|pickles|guacamole|mushrooms")) {
                regularToppings.add(topping);
                System.out.println("Added: " + topping);
            } else {
                System.out.println("Invalid topping. Please choose a valid topping or type 'done' to finish.");
            }
        }

        // Premium toppings - meats
        List<String> premiumMeats = new ArrayList<>();
        double meatCost = switch (size) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 1.00;
        };
        System.out.println("Each meat topping costs an additional $" + df.format(meatCost) + " for a " + size + "-inch sandwich.");
        System.out.println("Select premium meats (steak, ham, salami, roast beef, chicken, bacon). Type 'done' to finish:");
        while (true) {
            String meat = scanner.nextLine().trim().toLowerCase();
            if (meat.equals("done")) break;
            premiumMeats.add(meat);
            System.out.println("Added meat: " + meat);
        }

        // Ask for extra meat
        double extraMeatCost = switch (size) {
            case 4 -> 0.50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.50;
        };
        System.out.print("Would you like extra meat? (additional $" + df.format(extraMeatCost) + ") (yes/no): ");
        String extraMeat = scanner.nextLine().trim().toLowerCase();
        boolean hasExtraMeat = extraMeat.equals("yes");

        // Premium toppings - cheeses
        List<String> premiumCheeses = new ArrayList<>();
        double cheeseCost = switch (size) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.75;
        };
        System.out.println("Each cheese topping costs an additional $" + df.format(cheeseCost) + " for a " + size + "-inch sandwich.");
        System.out.println("Select premium cheeses (american, provolone, cheddar, swiss). Type 'done' to finish:");
        while (true) {
            String cheese = scanner.nextLine().trim().toLowerCase();
            if (cheese.equals("done")) break;
            premiumCheeses.add(cheese);
            System.out.println("Added cheese: " + cheese);
        }

        // Ask for extra cheese
        double extraCheeseCost = switch (size) {
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0.30;
        };
        System.out.print("Would you like extra cheese? (additional $" + df.format(extraCheeseCost) + ") (yes/no): ");
        String extraCheese = scanner.nextLine().trim().toLowerCase();
        boolean hasExtraCheese = extraCheese.equals("yes");

        // Select sauces
        List<String> sauces = new ArrayList<>();
        System.out.println("Select sauces (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette). Type 'done' to finish:");
        while (true) {
            String sauce = scanner.nextLine().trim().toLowerCase();
            if (sauce.equals("done")) break;
            sauces.add(sauce);
            System.out.println("Added sauce: " + sauce);
        }

        // Toasting option
        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        String toasted = scanner.nextLine().trim().toLowerCase();
        boolean isToasted = toasted.equals("yes");

        // Calculate total sandwich price
        double totalSandwichPrice = basePrice + (premiumMeats.size() * meatCost) + (hasExtraMeat ? extraMeatCost : 0)
                + (premiumCheeses.size() * cheeseCost) + (hasExtraCheese ? extraCheeseCost : 0);

        // Confirmation
        System.out.println("\nSandwich Details:");
        System.out.println(size + "-inch " + breadType + " bread");
        System.out.println("Regular Toppings: " + regularToppings);
        System.out.println("Premium Meats: " + premiumMeats + (hasExtraMeat ? " (with extra meat)" : ""));
        System.out.println("Premium Cheeses: " + premiumCheeses + (hasExtraCheese ? " (with extra cheese)" : ""));
        System.out.println("Sauces: " + sauces);
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));
        System.out.println("Total Sandwich Price: $" + df.format(totalSandwichPrice));
    }
}
