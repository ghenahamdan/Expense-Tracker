package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class ExpenseTrackerArrayList {

    private static ArrayList<String> expenseName = new ArrayList<>();
    private static ArrayList<Double> expenseAmount = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addExpense() {
        // 1) expense name validation
        String name = "";
        while (true) {
            System.out.println("Enter expense name: ");
            name = scanner.nextLine();

            // Check if name is empty
            if (name.trim().isEmpty()) {
                System.out.println("Error: Expense name cannot be empty!");
            } else {
                break;
            }
        }

        // 2) expense amount validation
        double amount = 0;
        while (true) {
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

        // Add to ArrayLists (auto-adds to end, no index needed)
        expenseName.add(name);
        expenseAmount.add(amount);
    }

    public static void viewExpenses() {
        // check if ArrayList is empty
        if (expenseName.size() == 0) {
            System.out.println("No expenses found. Please add expenses first.");
            return;
        }

        System.out.println("------All Expenses------");
        for (int i = 0; i < expenseName.size(); i++) {
            System.out.println(expenseName.get(i) + " - " + expenseAmount.get(i));
        }
    }

    public static void totalExpenses() {
        double total = 0;

        // check if ArrayList is empty
        if (expenseName.size() == 0) {
            System.out.println("No expenses found. Please add expenses first.");
            return;
        }

        for (int i = 0; i < expenseAmount.size(); i++) {
            total += expenseAmount.get(i);
        }
        System.out.println("Total Expenses is: " + total);
    }

    public static void highestExpenses() {
        // check if ArrayList is empty
        if (expenseName.size() == 0) {
            System.out.println("No expenses found. Please add expenses first.");
            return;
        }

        Double max = expenseAmount.get(0);
        int maxindex = 0;

        for (int i = 0; i < expenseAmount.size(); i++) {
            if (expenseAmount.get(i) > max) {
                max = expenseAmount.get(i);
                maxindex = i;
            }
        }
        System.out.println("The highest expense is " + expenseName.get(maxindex) + " - " + expenseAmount.get(maxindex));
    }
}