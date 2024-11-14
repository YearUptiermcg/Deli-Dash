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

        // Try writing the receipt to the file
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            writer.write(receipt); // Write the receipt to the file
            System.out.println("Receipt saved as " + filename); // Inform the user about the saved receipt
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }
}
