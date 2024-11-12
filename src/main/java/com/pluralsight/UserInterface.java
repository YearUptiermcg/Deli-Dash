package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("Welcome to DELI-cious! Please select an option:");
        System.out.println("1) New Order");
        System.out.println("0) Exit");

        int choice = scanner.nextInt();
        if (choice == 1) {
            createNewOrder();
        } else {
            System.out.println("Exiting... Thank you!");
        }
    }

    public void createNewOrder() {
        System.out.println("Creating a new order...");
        selectSandwich();
    }
}
