package com.pluralsight.util;

import com.pluralsight.util.ReceiptManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#.00");

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== Welcome to DELI-Dash ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    orderMenu();
                    break;
                case 0:
                    System.out.println("Goodbye! Come back soon.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void orderMenu() {
        List<String> orderDetails = new ArrayList<>();
        double totalPrice = 0;
        String customerName = "";

        System.out.print("\nPlease enter your name: ");
        customerName = scanner.nextLine();

        while (true) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    totalPrice += addSandwich(orderDetails);
                    break;
                case 2:
                    totalPrice += addDrink(orderDetails);
                    break;
                case 3:
                    totalPrice += addChips(orderDetails);
                    break;
                case 4:
                    checkout(orderDetails, totalPrice, customerName);
                    return; // End the order process
                case 0:
                    System.out.println("Order canceled.");
                    return; // Return to the home screen
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private double addSandwich(List<String> orderDetails) {
        System.out.println("\nLet's build your sandwich!");

        System.out.println("Choose sandwich size (4, 8, or 12 inches):");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double basePrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 5.50;
        };

        System.out.println("You selected a " + size + "-inch sandwich. Base price: $" + df.format(basePrice));

        System.out.println("Choose bread type (white, wheat, rye, wrap):");
        String breadType = scanner.nextLine();
        System.out.println("You selected " + breadType + " bread.");

        List<String> regularToppings = new ArrayList<>();
        System.out.println("Select regular toppings (lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms). Type 'done' to finish:");
        while (true) {
            String topping = scanner.nextLine().trim().toLowerCase();
            if (topping.equals("done")) break;
            regularToppings.add(topping);
            System.out.println("Added: " + topping);
        }

        List<String> premiumMeats = new ArrayList<>();
        double meatCost = switch (size) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 1.00;
        };
        double extraMeatCost = switch (size) {
            case 4 -> 0.50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.50;
        };
        System.out.println("Each meat topping costs an additional $" + df.format(meatCost) + " for a " + size + "-inch sandwich.");
        System.out.println("Select premium meats (steak, ham, salami, roast beef, chicken, bacon). Type 'done' to finish:");
        while (true) {
            String meat = scanner.nextLine().trim().toLowerCase();
            if (meat.equals("done")) break;
            premiumMeats.add(meat);
            System.out.println("Added meat: " + meat);

            System.out.print("Would you like extra meat (additional $" + df.format(extraMeatCost) + ")? (yes/no): ");
            String extraMeat = scanner.nextLine().trim().toLowerCase();
            if (extraMeat.equals("yes")) {
                System.out.println("Added extra meat: " + meat);
            }
        }

        List<String> premiumCheeses = new ArrayList<>();
        double cheeseCost = switch (size) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.75;
        };
        double extraCheeseCost = switch (size) {
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0.30;
        };
        System.out.println("Each cheese topping costs an additional $" + df.format(cheeseCost) + " for a " + size + "-inch sandwich.");
        System.out.println("Select premium cheeses (american, provolone, cheddar, swiss). Type 'done' to finish:");
        while (true) {
            String cheese = scanner.nextLine().trim().toLowerCase();
            if (cheese.equals("done")) break;
            premiumCheeses.add(cheese);
            System.out.println("Added cheese: " + cheese);

            System.out.print("Would you like extra cheese (additional $" + df.format(extraCheeseCost) + ")? (yes/no): ");
            String extraCheese = scanner.nextLine().trim().toLowerCase();
            if (extraCheese.equals("yes")) {
                System.out.println("Added extra cheese: " + cheese);
            }
        }

        List<String> sauces = new ArrayList<>();
        System.out.println("Select sauces (hot sauce, BBQ, honey mustard, ranch, au jus). Type 'done' to finish:");
        while (true) {
            String sauce = scanner.nextLine().trim().toLowerCase();
            if (sauce.equals("done")) break;
            sauces.add(sauce);
            System.out.println("Added sauce: " + sauce);
        }

        // Toast option added here
        System.out.println("Would you like your bread toasted? (yes/no): ");
        String toastOption = scanner.nextLine().trim().toLowerCase();
        boolean toasted = toastOption.equals("yes");

        double totalSandwichPrice = basePrice + (premiumMeats.size() * meatCost) + (premiumCheeses.size() * cheeseCost);
        orderDetails.add(size + "-inch " + breadType + " bread, Toasted: " + (toasted ? "Yes" : "No"));
        orderDetails.add("Regular Toppings: " + regularToppings);
        orderDetails.add("Premium Meats: " + premiumMeats);
        orderDetails.add("Premium Cheeses: " + premiumCheeses);
        orderDetails.add("Sauces: " + sauces);

        System.out.println("\n=== Sandwich Details ===");
        System.out.println("Size: " + size + "-inch " + breadType + " bread");
        System.out.println("Regular Toppings: " + regularToppings);
        System.out.println("Premium Meats: " + premiumMeats);
        System.out.println("Premium Cheeses: " + premiumCheeses);
        System.out.println("Sauces: " + sauces);
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.println("Total Sandwich Price: $" + df.format(totalSandwichPrice));

        return totalSandwichPrice;
    }

    private double addDrink(List<String> orderDetails) {
        List<String> drinks = new ArrayList<>();
        double totalDrinkPrice = 0;

        System.out.println("\nWould you like to add a drink? (yes/no): ");
        String wantDrinks = scanner.nextLine().trim().toLowerCase();
        if (wantDrinks.equals("yes")) {
            System.out.println("Select drink size:\n1. Small ($1.50)\n2. Medium ($2.00)\n3. Large ($2.50)");
            int sizeOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            double drinkPrice = switch (sizeOption) {
                case 1 -> 1.50;
                case 2 -> 2.00;
                case 3 -> 2.50;
                default -> 1.50;
            };

            System.out.println("Select drink flavor:\n1. Cherry Cola\n2. Lemonade\n3. Iced Tea\n4. Water");
            int flavorOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String drinkFlavor = switch (flavorOption) {
                case 1 -> "Cherry Coke";
                case 2 -> "Lemonade";
                case 3 -> "Iced Tea";
                case 4 -> "Water";
                default -> "Cherry Cola";
            };

            drinks.add(drinkFlavor);
            orderDetails.add("Drink: " + drinkFlavor + " (" + (sizeOption == 1 ? "Small" : sizeOption == 2 ? "Medium" : "Large") + ")");
            System.out.println("Total Drink Price: $" + df.format(drinkPrice));
            totalDrinkPrice += drinkPrice;
        }

        return totalDrinkPrice;
    }

    private double addChips(List<String> orderDetails) {
        System.out.println("\nWould you like to add chips? (yes/no): ");
        String wantChips = scanner.nextLine().trim().toLowerCase();
        if (wantChips.equals("yes")) {
            System.out.println("Select chip flavor:\n1. Classic ($1.50)\n2. BBQ ($1.50)\n3. Sour Cream & Onion ($1.50)");
            int flavorOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            double chipPrice = 1.50;
            String chipFlavor = switch (flavorOption) {
                case 1 -> "Classic";
                case 2 -> "BBQ";
                case 3 -> "Sour Cream & Onion";
                default -> "Classic";
            };
            orderDetails.add("Chips: " + chipFlavor);
            System.out.println("Total Chips Price: $" + df.format(chipPrice));
            return chipPrice;
        } else {
            return 0.0;
        }
    }

    private void checkout(List<String> orderDetails, double totalPrice, String customerName) {
        System.out.println("\n=== Checkout ===");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Details:");
        for (String detail : orderDetails) {
            System.out.println(detail);
        }
        System.out.println("Total Price: $" + df.format(totalPrice));

        // Create the receipt content
        String receipt = "Customer: " + customerName + "\n" + String.join("\n", orderDetails) + "\nTotal: $" + df.format(totalPrice);

        // Save the receipt
        ReceiptManager.saveReceipt(receipt);
    }
}