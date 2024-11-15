# DELI-Dash: Sandwich Shop POS System

## Overview

The **DELI-Dash Sandwich Shop POS System** is a point-of-sale application designed to streamline and automate sandwich orders for a sandwich shop. It allows customers to customize their sandwiches, add chips and drinks, view their order details, and generate a receipt. The application adheres to object-oriented programming principles, ensuring maintainability and scalability.

---

## Features

- **Order Customization**: Customers can specify sandwich size, bread type, toppings, sauces, and extras.
- **Chips and Drinks**: Select from a predefined list of chips and drinks, with chips priced at $1.50 each.
- **User-Friendly Checkout**: Displays order summary and allows customers to confirm their orders.
- **Receipt Management**: Generates a well-designed, timestamped receipt and saves it in the `receipts` folder.
- **Reusability**: After completing an order, the system loops back to the main menu, enabling multiple transactions.

---

## Screenshots

### Main Menu
![Main Menu](src/screenshots/main_menu.png

### Order Menu
![Order Menu](src/screenshots/order_menu.png

### Receipt Example
![Receipt Example](src/screenshots/receipt_example.PNG

---

## Interesting Code Section

One of the most interesting sections of the code is the **Receipt Formatting** method in the `ReceiptManager` class. This method generates a beautifully formatted receipt that includes the customer's name, current date and time, order details, and a thank-you message.

### Code Snippet:
```java
private static String generateReceiptDesign(String receipt, String userName) {
    String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    StringBuilder receiptBuilder = new StringBuilder();
    receiptBuilder.append("========================================\n");
    receiptBuilder.append("                DELI-Dash\n");
    receiptBuilder.append("          Sandwich Shop Receipt\n");
    receiptBuilder.append("========================================\n");
    receiptBuilder.append("Date: ").append(currentDate).append("\n");
    receiptBuilder.append("Customer: ").append(userName).append("\n");
    receiptBuilder.append("----------------------------------------\n");
    receiptBuilder.append(receipt);
    receiptBuilder.append("\n----------------------------------------\n");
    receiptBuilder.append("Thank you for your order!\n");
    receiptBuilder.append("Visit us again soon at DELI-Dash!\n");
    receiptBuilder.append("========================================\n");

    return receiptBuilder.toString();
}
