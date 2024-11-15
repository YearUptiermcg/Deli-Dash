package com.pluralsight.util;

import com.pluralsight.util.ReceiptManager;
import java.text.DecimalFormat;
import java.util.Arrays;
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
                    System.out.println("Thank you for shopping with us! Your order will be up shortly.");
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

        // Sandwich size options as a list
        System.out.println("Select sandwich size:");
        System.out.println("1. 4-inch (5.50)");
        System.out.println("2. 8-inch (7.00)");
        System.out.println("3. 12-inch (8.50)");
        int sizeOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        int size = switch (sizeOption) {
            case 1 -> 4;
            case 2 -> 8;
            case 3 -> 12;
            default -> 4;
        };

        double basePrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 5.50;
        };

        System.out.println("You selected a " + size + "-inch sandwich.");

        // Bread type options as a list
        System.out.println("Select bread type:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        int breadOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String breadType = switch (breadOption) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };
        System.out.println("You selected " + breadType + " bread.");

        // Ask if the bread should be toasted
        System.out.print("Would you like your bread toasted? (yes/no): ");
        String toasted = scanner.nextLine().trim().toLowerCase();
        boolean isToasted = toasted.equals("yes");
        if (isToasted) {
            System.out.println("Your bread will be toasted.");
        } else {
            System.out.println("Your bread will not be toasted.");
        }

        // Regular Toppings - numbered list
        List<String> regularToppings = List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
        System.out.println("\nSelect regular toppings (choose number):");
        for (int i = 0; i < regularToppings.size(); i++) {
            System.out.println((i + 1) + ". " + regularToppings.get(i));
        }
        List<String> selectedRegularToppings = new ArrayList<>();
        System.out.println("Enter the number of your selection (type 'done' to finish):");
        while (true) {
            String toppingInput = scanner.nextLine().trim();
            if (toppingInput.equalsIgnoreCase("done")) break;
            try {
                int toppingIndex = Integer.parseInt(toppingInput) - 1;
                if (toppingIndex >= 0 && toppingIndex < regularToppings.size()) {
                    selectedRegularToppings.add(regularToppings.get(toppingIndex));
                    System.out.println("Added: " + regularToppings.get(toppingIndex));
                } else {
                    System.out.println("Invalid selection, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number or 'done'.");
            }
        }

        // Premium Meats - numbered list
        List<String> premiumMeats = List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
        System.out.println("\nSelect premium meats (choose number):");
        for (int i = 0; i < premiumMeats.size(); i++) {
            System.out.println((i + 1) + ". " + premiumMeats.get(i));
        }
        List<String> selectedPremiumMeats = new ArrayList<>();
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
        System.out.println("Enter the number of your selection (type 'done' to finish):");
        while (true) {
            String meatInput = scanner.nextLine().trim();
            if (meatInput.equalsIgnoreCase("done")) break;
            try {
                int meatIndex = Integer.parseInt(meatInput) - 1;
                if (meatIndex >= 0 && meatIndex < premiumMeats.size()) {
                    selectedPremiumMeats.add(premiumMeats.get(meatIndex));
                    System.out.println("Added meat: " + premiumMeats.get(meatIndex));

                    // Extra meat selection
                    System.out.print("Would you like extra meat (additional $" + df.format(extraMeatCost) + ")? (yes/no): ");
                    String extraMeat = scanner.nextLine().trim().toLowerCase();
                    if (extraMeat.equals("yes")) {
                        System.out.println("Added extra meat: " + premiumMeats.get(meatIndex));
                    }
                } else {
                    System.out.println("Invalid selection, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number or 'done'.");
            }
        }

        // Premium Cheeses - numbered list
        List<String> premiumCheeses = List.of("American", "Provolone", "Cheddar", "Swiss");
        System.out.println("\nSelect premium cheeses (choose number):");
        for (int i = 0; i < premiumCheeses.size(); i++) {
            System.out.println((i + 1) + ". " + premiumCheeses.get(i));
        }
        List<String> selectedPremiumCheeses = new ArrayList<>();
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
        System.out.println("Enter the number of your selection (type 'done' to finish):");
        while (true) {
            String cheeseInput = scanner.nextLine().trim();
            if (cheeseInput.equalsIgnoreCase("done")) break;
            try {
                int cheeseIndex = Integer.parseInt(cheeseInput) - 1;
                if (cheeseIndex >= 0 && cheeseIndex < premiumCheeses.size()) {
                    selectedPremiumCheeses.add(premiumCheeses.get(cheeseIndex));
                    System.out.println("Added cheese: " + premiumCheeses.get(cheeseIndex));

                    // Extra cheese selection
                    System.out.print("Would you like extra cheese (additional $" + df.format(extraCheeseCost) + ")? (yes/no): ");
                    String extraCheese = scanner.nextLine().trim().toLowerCase();
                    if (extraCheese.equals("yes")) {
                        System.out.println("Added extra cheese: " + premiumCheeses.get(cheeseIndex));
                    }
                } else {
                    System.out.println("Invalid selection, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number or 'done'.");
            }
        }

        // Sauces - List of sauces
        List<String> sauces = List.of("Ketchup", "Mustard", "Mayo", "Au Jus");
        System.out.println("\nSelect sauces (choose number, no extra charge):");
        for (int i = 0; i < sauces.size(); i++) {
            System.out.println((i + 1) + ". " + sauces.get(i));
        }
        String selectedSauce = scanner.nextLine().trim();

        // Calculate total for this sandwich
        double sandwichPrice = basePrice + (selectedPremiumMeats.size() * meatCost) + (selectedPremiumCheeses.size() * cheeseCost);
        System.out.println("Total sandwich price: $" + df.format(sandwichPrice));

        // Save sandwich order details
        orderDetails.add("\nSandwich (" + size + "-inch): $" + df.format(sandwichPrice));
        return sandwichPrice;
    }

    private double addDrink(List<String> orderDetails) {
        // Drink options - list of flavors
        System.out.println("\nSelect drink flavor:");
        System.out.println("1. Cherry Cola");
        System.out.println("2. Lemonade");
        System.out.println("3. Iced Tea");
        System.out.println("4. Water");
        int flavorOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String drinkFlavor = switch (flavorOption) {
            case 1 -> "Cherry Cola";
            case 2 -> "Lemonade";
            case 3 -> "Iced Tea";
            case 4 -> "Water";
            default -> "Cherry Cola";
        };

        System.out.println("You selected: " + drinkFlavor);

        // Drink size options - list
        System.out.println("Select drink size:");
        System.out.println("1. Small (2.00)");
        System.out.println("2. Medium (2.50)");
        System.out.println("3. Large (3.00)");
        int drinkSizeOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String drinkSize = switch (drinkSizeOption) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Small";
        };
        double drinkPrice = switch (drinkSize) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 2.00;
        };
        orderDetails.add("Drink (" + drinkSize + " - " + drinkFlavor + "): $" + df.format(drinkPrice));
        return drinkPrice;
    }

    private double addChips(List<String> orderDetails) {
        System.out.println("\nSelect chip flavor (All are 1.50):");
        System.out.println("1. BBQ");
        System.out.println("2. Sour Cream & Onion");
        System.out.println("3. Salt & Vinegar");
        System.out.println("4. Plain");
        int chipOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String chipFlavor = switch (chipOption) {
            case 1 -> "BBQ";
            case 2 -> "Sour Cream & Onion";
            case 3 -> "Salt & Vinegar";
            case 4 -> "Plain";
            default -> "BBQ";
        };

        System.out.println("You selected: " + chipFlavor);

        double chipPrice = 1.50;
        orderDetails.add("Chips (" + chipFlavor + "): $" + df.format(chipPrice));
        return chipPrice;
    }

    public void checkout(List<String> orderDetails, double totalPrice, String customerName) {
        System.out.println("\n=== Checkout ===");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Details:");
        for (String detail : orderDetails) {
            System.out.println(detail);
        }
        System.out.println("Total Price: $" + df.format(totalPrice));

        // Detailed lists of toppings, meats, and cheeses
        List<String> toppings = Arrays.asList("Lettuce", "Tomato", "Pickles"); // Example selected toppings
        List<String> cheeses = Arrays.asList("Cheddar", "Swiss"); // Example selected cheeses
        List<String> meats = Arrays.asList("Turkey", "Bacon"); // Example selected meats
        boolean isToasted = true; // Example whether the sandwich is toasted or not

        // Display the toppings, cheeses, meats, and toasting status during checkout
        System.out.println("\n=== Sandwich Customization ===");

        System.out.println("Toppings: " + (toppings.isEmpty() ? "None" : String.join(", ", toppings)));
        System.out.println("Cheeses: " + (cheeses.isEmpty() ? "None" : String.join(", ", cheeses)));
        System.out.println("Meats: " + (meats.isEmpty() ? "None" : String.join(", ", meats)));
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));

        // Create the receipt content (basic receipt details)
        String receipt = "Customer: " + customerName + "\n" + String.join("\n", orderDetails) + "\nTotal: $" + df.format(totalPrice);

        // Save the receipt with all the required details
        ReceiptManager.saveReceipt(receipt, customerName, toppings, cheeses, meats, isToasted);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayMenu();
    }
}
