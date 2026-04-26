package org.example;

import java.util.Scanner;

public class ExpenseTrackerArray {

    private String[] expenseName;
    private Double[] expenseAmount;
    private int arrayIndex;
    private Scanner scanner;

    // Constructor to initialize the arrays and scanner
    public ExpenseTrackerArray() {
        this.expenseName = new String[10];
        this.expenseAmount = new Double[10];
        this.arrayIndex = 0;
        this.scanner = new Scanner(System.in);
    }

    public void addExpense() {
        // 1) check if array is full
        if (arrayIndex >= expenseName.length) {
            System.out.println("Storage is full! Cannot add more expenses.");
            return;  // Don't increment
        }

        // 2) expense name validation
        String name = "";
        while (true) {
            System.out.println("Enter expense name: ");
            name = scanner.nextLine();

            // Check if name is empty
            if (name.trim().isEmpty()) {  // trim() removes spaces, isEmpty() checks if nothing left
                System.out.println("Error: Expense name cannot be empty!");
            } else {
                break;  // if name is valid exit loop
            }
        }

        // 3) expense amount validation
        double amount = 0;
        while(true) {
            System.out.println("Enter expense amount: ");

            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline after nextDouble()
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Error, amount must be greater than 0!");
                }
            } else {
                System.out.println("Error, enter a valid number!");
                scanner.next();  // Consume the invalid input
            }
        }

        expenseName[arrayIndex] = name;
        expenseAmount[arrayIndex] = amount;
        arrayIndex++;  // Increment after successful add
    }

    public void viewExpenses() {
        // check if array is empty
        if (arrayIndex == 0) {
            System.out.println("No expenses found. Please add expenses first.");
            return;  // Exit the method early
        }

        System.out.println("------All Expenses------");
        for (int i = 0; i < arrayIndex; i++) {
            System.out.println(expenseName[i] + " - " + expenseAmount[i]);
        }
    }

    public void totalExpenses() {
        double total = 0;
        // check if array is empty
        if (arrayIndex == 0) {
            System.out.println("No expenses found. Please add expenses first.");
            return;  // Exit the method early
        }

        for(int i = 0; i < arrayIndex; i++) {
            total += expenseAmount[i];
        }
        System.out.println("Total Expenses is: " + total);
    }

    public void highestExpenses() {
        // check if array is empty
        if (arrayIndex == 0) {
            System.out.println("No expenses found. Please add expenses first.");
            return;  // Exit the method early
        }

        Double max = expenseAmount[0];
        int maxindex = 0;  // Track the INDEX of the highest expense

        for(int i = 0; i < arrayIndex; i++) {
            if(expenseAmount[i] > max) {
                max = expenseAmount[i];
                maxindex = i;  // Remembers which index had the max
            }
        }
        System.out.println("The highest expense is " + expenseName[maxindex] + " - " + expenseAmount[maxindex]);
    }
}