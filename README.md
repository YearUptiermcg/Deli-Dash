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
#Main Menu 
<img width="217" alt="main_menu" src="https://github.com/user-attachments/assets/b341ef11-803b-49dd-9720-6680f9fe394c">
-------------------------------------------------------------------------------------------------------------------
#Order Menu
<img width="307" alt="order_menu" src="https://github.com/user-attachments/assets/e655fec5-7b5c-40b4-95dd-a543903b94d9">
--------------------------------------------------------------------------------------------------------------------
#Drinks Menu 
<img width="363" alt="drink_menu" src="https://github.com/user-attachments/assets/f3bfb484-652f-485d-984a-cd1aeabfd468">
--------------------------------------------------------------------------------------------------------------------
#Chips Menu
<img width="303" alt="chips_menu" src="https://github.com/user-attachments/assets/56c33887-a38a-439b-b808-8ec39e99587f">
--------------------------------------------------------------------------------------------------------------------
#Sauces Menu
<img width="233" alt="sauces" src="https://github.com/user-attachments/assets/60f982fb-c983-4427-beef-2c93a6c3c34d">
----------------------------------------------------------------------------------------------------------------------
#Toppings Menu
<img width="238" alt="toppings" src="https://github.com/user-attachments/assets/93c4961d-b0c4-4d8a-95eb-0e2bbebed62b">
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
