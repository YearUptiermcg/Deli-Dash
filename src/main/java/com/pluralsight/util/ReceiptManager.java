package com.pluralsight.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {
    // Updated saveReceipt method to accept more parameters
    public static void saveReceipt(String receipt, String customerName, List<String> toppings, List<String> cheeses, List<String> meats, boolean isToasted) {
        // Ensure the receipts directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir(); // Create the receipts directory if it doesn't exist
        }

        // Generate a unique filename based on the current date and time
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // Construct the formatted receipt content
        String formattedReceipt = generateReceiptDesign(receipt, customerName, toppings, cheeses, meats, isToasted);

        // Try writing the receipt to the file
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            writer.write(formattedReceipt); // Write the formatted receipt to the file
            System.out.println("Receipt saved as " + filename); // Inform the user about the saved receipt
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }

    // Method to generate a visually formatted receipt design
    private static String generateReceiptDesign(String receipt, String customerName, List<String> toppings, List<String> cheeses, List<String> meats, boolean isToasted) {
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("========================================\n");
        receiptBuilder.append("                DELI-Dash\n");
        receiptBuilder.append("          Sandwich Shop Receipt\n");
        receiptBuilder.append("========================================\n");
        receiptBuilder.append("Date: ").append(currentDate).append("\n");
        receiptBuilder.append("Customer: ").append(customerName).append("\n");
        receiptBuilder.append("----------------------------------------\n");

        // Add toppings, cheeses, meats, and toasted status to the receipt
        if (!toppings.isEmpty()) {
            receiptBuilder.append("Toppings: ").append(String.join(", ", toppings)).append("\n");
        } else {
            receiptBuilder.append("Toppings: None\n");
        }

        if (!cheeses.isEmpty()) {
            receiptBuilder.append("Cheeses: ").append(String.join(", ", cheeses)).append("\n");
        } else {
            receiptBuilder.append("Cheeses: None\n");
        }

        if (!meats.isEmpty()) {
            receiptBuilder.append("Meats: ").append(String.join(", ", meats)).append("\n");
        } else {
            receiptBuilder.append("Meats: None\n");
        }

        receiptBuilder.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
        receiptBuilder.append("----------------------------------------\n");
        receiptBuilder.append(receipt);
        receiptBuilder.append("\n----------------------------------------\n");
        receiptBuilder.append("Thank you for your order!\n");
        receiptBuilder.append("Visit us again soon at DELI-Dash!\n");
        receiptBuilder.append("========================================\n");

        return receiptBuilder.toString();
    }
}
