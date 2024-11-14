package com.pluralsight;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#.00");

    //Home Screen
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
                    displayOrderMenu();  // Initiate order menu
                    break;
                case 0:
                    System.out.println("Goodbye! Come back soon.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Display Order Menu
    private void displayOrderMenu() {
        List<String> orderItems = new ArrayList<>();
        double totalPrice = 0.0;

        while (true) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order and Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    String sandwich = selectSandwich();
                    orderItems.add("Sandwich: " + sandwich);
                    totalPrice += calculateSandwichPrice(sandwich);
                    System.out.println("Sandwich added to order.");
                    break;
                case 2:
                    String drink = selectDrink();
                    orderItems.add("Drink: " + drink);
                    totalPrice += extractPrice(drink);
                    System.out.println("Drink added to order.");
                    break;
                case 3:
                    String chips = selectChips();
                    orderItems.add("Chips: " + chips);
                    totalPrice += 1.50; // Chips are always $1.50
                    System.out.println("Chips added to order.");
                    break;
                case 4:
                    checkout(orderItems, totalPrice);
                    return;  // Exit after checkout
                case 0:
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private String selectSandwich() {
        System.out.println("\nLet's build your sandwich!");

        System.out.print("What is your name? ");
        String customerName = scanner.nextLine();

        System.out.println("Choose sandwich size (4, 8, or 12 inches):");
        int size = scanner.nextInt();
        scanner.nextLine();

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

        // Ask for premium toppings (meats and cheeses) with extra options
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

            // Option for extra meat
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
        System.out.println("Each cheese topping costs an additional $" + df.format(cheeseCost) + " for a " + size + "-inch sandwich.");
        System.out.println("Select premium cheeses (american, provolone, cheddar, swiss). Type 'done' to finish:");
        while (true) {
            String cheese = scanner.nextLine().trim().toLowerCase();
            if (cheese.equals("done")) break;
            premiumCheeses.add(cheese);
            System.out.println("Added cheese: " + cheese);

            // Option for extra cheese
            System.out.print("Would you like extra cheese (additional $" + df.format(cheeseCost) + ")? (yes/no): ");
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

        // Summarizing sandwich choices
        return size + "-inch " + breadType + " with " + regularToppings + " and " + premiumMeats + " and " + premiumCheeses;
    }

    private double calculateSandwichPrice(String sandwich) {
        // Basic price calculation based on size - adjust as needed
        if (sandwich.contains("4-inch")) return 5.50;
        if (sandwich.contains("8-inch")) return 7.00;
        if (sandwich.contains("12-inch")) return 8.50;
        return 0.0;
    }

    private String selectDrink() {
        System.out.println("Choose drink size:\n1. Small ($1.50)\n2. Medium ($2.00)\n3. Large ($2.50)");
        int sizeOption = scanner.nextInt();
        scanner.nextLine();

        double drinkPrice = switch (sizeOption) {
            case 1 -> 1.50;
            case 2 -> 2.00;
            case 3 -> 2.50;
            default -> 1.50;
        };
        String sizeLabel = switch (sizeOption) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Small";
        };

        System.out.println("Select drink flavor:\n1. Lemonade\n2. Cherry Coke\n3. Water\n4. Sprite");
        int flavorOption = scanner.nextInt();
        scanner.nextLine();

        String flavor = switch (flavorOption) {
            case 1 -> "Lemonade";
            case 2 -> "Cherry Coke";
            case 3 -> "Water";
            case 4 -> "Sprite";
            default -> "Lemonade";
        };

        return sizeLabel + " " + flavor + " - $" + df.format(drinkPrice);
    }

    private String selectChips() {
        System.out.println("Choose chip type:\n1. Potato Chips\n2. Red Doritos\n3. Blue Doritos");
        int chipOption = scanner.nextInt();
        scanner.nextLine();

        String chipType = switch (chipOption) {
            case 1 -> "Potato Chips";
            case 2 -> "Red Doritos";
            case 3 -> "Blue Doritos";
            default -> "Potato Chips";
        };

        return chipType;
    }

    private double extractPrice(String item) {
        if (item.contains("Small")) return 1.50;
        if (item.contains("Medium")) return 2.00;
        if (item.contains("Large")) return 2.50;
        return 0.0;
    }

    private void checkout(List<String> orderItems, double totalPrice) {
        System.out.println("\n=== Checkout ===");
        for (String item : orderItems) {
            System.out.println(item);
        }
        System.out.println("Total Price: $" + df.format(totalPrice));

        System.out.print("Would you like to confirm the order? (yes/no): ");
        String confirmation = scanner.nextLine().toLowerCase();

        if (confirmation.equals("yes")) {
            System.out.println("Order confirmed. Thank you for choosing DELI-cious!");
        } else {
            System.out.println("Order canceled.");
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayMenu();
    }
}
