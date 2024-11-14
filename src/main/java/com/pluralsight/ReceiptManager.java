package com.pluralsight.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    // Method to save the receipt to a file in the "receipts" directory
    public static void saveReceipt(String receipt) {
        // Ensure the receipts directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir(); // Create the receipts directory if it doesn't exist
        }

        // Generate a unique filename based on the current date and time
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // Construct the formatted receipt content
        String formattedReceipt = generateReceiptDesign(receipt);

        // Try writing the receipt to the file
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            writer.write(formattedReceipt); // Write the formatted receipt to the file
            System.out.println("Receipt saved as " + filename); // Inform the user about the saved receipt
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }

    // Method to generate a visually formatted receipt design
    private static String generateReceiptDesign(String receipt) {
        // Current date and time for the header
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Start the receipt design with a header
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("========================================\n");
        receiptBuilder.append("              DELI-Dash\n");
        receiptBuilder.append("          Sandwich Shop Receipt\n");
        receiptBuilder.append("========================================\n");
        receiptBuilder.append("Date: " + currentDate + "\n");
        receiptBuilder.append("----------------------------------------\n");

        // Add the order details
        receiptBuilder.append(receipt);

        // Footer with a thank you note
        receiptBuilder.append("\n----------------------------------------\n");
        receiptBuilder.append("Thank you for your order!\n");
        receiptBuilder.append("Visit us again soon at DELI-Dash!\n");
        receiptBuilder.append("========================================\n");

        return receiptBuilder.toString();
    }
}
