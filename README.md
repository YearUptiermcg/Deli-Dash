# DELI-Dash: Sandwich Shop POS System

## Project Overview
**DELI-Dash** is a Java POS application that simplifies sandwich ordering for customers. It allows them to:
- Customize sandwiches with different sizes, breads, toppings, and sauces.
- Add drinks and chips to their order.
- View and confirm or cancel the order summary.
- Save receipts with a timestamp for each transaction.


---

## Features

### Home Screen:
- **Start New Order**: Begin a new sandwich order.
- **Exit**: Exit the application.

### Order Customization Screen:
- **Sandwich Options**:
  - Choose bread type (4-inch, 8-inch, or 12-inch).
  - Select regular and premium toppings.
  - Choose sauces, with options for toasting the sandwich.
- **Add Chips & Drinks**:
  - Select a chip flavor ($1.50 each).
  - Choose drink size (Small, Medium, Large) with right prices.
- **Order Review**: View selected items before proceeding to checkout.

### Checkout Screen:
- Review the final order with detailed price breakdown.
- Confirm the order or cancel it.
- Save the receipt in a timestamped `.txt` file.

---

## Components

### ReceiptManager Class:
Handles the generation and formatting of receipts. It ensures the receipt includes:
- Customer name
- Sandwich details (bread type, toppings, sauces)
- Total price

### Order Class:
Manages the specifics of a customer's sandwich order, including the bread, toppings, sauces, and drinks. It calculates the total price and provides order details.

### Main Class:
Serves as the entry point for the program and provides the text-based menu for interaction. Users can select options to start a new order, view orders, or exit the program.

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) installed on your machine.
- A text editor or IDE for Java development (e.g., IntelliJ IDEA, Eclipse).

### Installation
1. Clone the repository or download the source code.
2. Open the project in your IDE.
3. No external dependencies are required; all code is self-contained.
4. The program will automatically create a folder called `receipts` to store the generated receipt files.

### Running the Application
1. Compile the Java files.
2. Run the **Main class** to start the application.
3. Follow the on-screen instructions to add items to the order, view the order summary, and generate the receipt.

---

## Usage
- After starting the application, the user will see the **Home Screen**.
- They can create a new order, customize their sandwich, and add chips and drinks.
- The **Checkout Screen** will allow them to review the order and confirm it.
- After confirmation, the receipt will be generated and saved with a timestamped filename (e.g., `20241115_100709.txt`).
- The user can view previous orders or start a new one.

### Menu Options:
1. **Start New Order**: Begin a new sandwich order.
0. **Exit**: Exit the application.
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

--------------------------------------------------------------------------------------------------------

## License
This project is licensed under the MIT License.
