package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTrackerHash {

    // HashMap stores expense name as key and amount as value
    private HashMap<String, Double> expenses;
    private Scanner scanner;

    // Constructor to initialize the hashmap and scanner
    public ExpenseTrackerHash() {
        this.expenses = new HashMap<>();  // Create new empty HashMap
        this.scanner = new Scanner(System.in);
    }

    public void addExpense() {
        // 1) expense name validation
        String name = "";
        while (true) {
            System.out.println("Enter expense name: ");
            name = scanner.nextLine();

            // Check if name is empty (trim() removes spaces, isEmpty() checks if nothing left)
            if (name.trim().isEmpty()) {
                System.out.println("Error: Expense name cannot be empty!");
            } else {
                // Check if expense name already exists in the hashmap (keys must be unique)
                if (expenses.containsKey(name)) {
                    System.out.println("Error: An expense with this name already exists!");
                    System.out.println("Please use a different name.");
                } else {
                    break;  // if name is valid and unique, exit loop
                }
            }
        }

        // 2) expense amount validation
        double amount = 0;
        while (true) {
            System.out.println("Enter expense amount: ");

            // Check if the next input is a valid double
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline after nextDouble()
                if (amount > 0) {
                    break;  // Valid amount, exit loop
                } else {
                    System.out.println("Error, amount must be greater than 0!");
                }
            } else {
                System.out.println("Error, enter a valid number!");
                scanner.next();  // Consume the invalid input so it doesn't cause infinite loop
            }
        }

        // Add to hashmap
        expenses.put(name, amount);
    }

    public void viewExpenses() {
        // check if hashmap is empty
        if (expenses.isEmpty()) {
            System.out.println("No expenses found. Please add expenses first.");
            return;  // Exit the method early
        }

        System.out.println("------All Expenses------");

        // Loop through all entries in the HashMap
        // entrySet() returns a set of all key value pairs
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void totalExpenses() {
        // check if HashMap is empty
        if (expenses.isEmpty()) {
            System.out.println("No expenses found. Please add expenses first.");
            return;  // Exit the method early
        }

        double total = 0;

        // Loop through all values (amounts ) in the HashMap
        for (double amount : expenses.values()) {
            total += amount;  // Add each amount to the running total
        }
        System.out.println("Total Expenses is: " + total);
    }

    public void highestExpenses() {
        // check if hashmap is empty
        if (expenses.isEmpty()) {
            System.out.println("No expenses found. Please add expenses first.");
            return;  // Exit the method early
        }

        String highestName = "";
        double highestAmount = 0;  // Start with -1 because amounts are always positive

        // Loop through all entries to find the highest amount
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            if (entry.getValue() > highestAmount) {
                highestAmount = entry.getValue();  // Update highest amount
                highestName = entry.getKey();      // Remember which expense had it
            }
        }
        System.out.println("The highest expense is " + highestName + " - " + highestAmount);
    }
}