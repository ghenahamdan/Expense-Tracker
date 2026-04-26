package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            // Display version selection menu
            System.out.println("\n===== Expense Tracker System =====");
            System.out.println("Choose which version to use:");
            System.out.println("1. Array version (fixed size - max 10 expenses)");
            System.out.println("2. ArrayList version (dynamic size - unlimited)");
            System.out.println("3. HashMap version (key-value pairs, no duplicate names)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (mainChoice) {
                case 1:
                    runArrayVersion();
                    break;
                case 2:
                    runArrayListVersion();
                    break;
                case 3:
                    runHashMapVersion();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
                    break;
            }

        } while (mainChoice != 4);

        scanner.close();
    }

    // Method to run the Array version
    public static void runArrayVersion() {
        ExpenseTrackerArray tracker = new ExpenseTrackerArray();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Expense Tracker (Array Version) =====");
            System.out.println("1. Add expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Calculate total expenses");
            System.out.println("4. Find highest expense");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tracker.addExpense();
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    tracker.totalExpenses();
                    break;
                case 4:
                    tracker.highestExpenses();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input, try again\n");
                    break;
            }

        } while (choice != 5);
    }

    // Method to run the ArrayList version
    public static void runArrayListVersion() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Expense Tracker (ArrayList Version) =====");
            System.out.println("1. Add expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Calculate total expenses");
            System.out.println("4. Find highest expense");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    ExpenseTrackerArrayList.addExpense();
                    break;
                case 2:
                    ExpenseTrackerArrayList.viewExpenses();
                    break;
                case 3:
                    ExpenseTrackerArrayList.totalExpenses();
                    break;
                case 4:
                    ExpenseTrackerArrayList.highestExpenses();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input, try again\n");
                    break;
            }

        } while (choice != 5);
    }

    // Method to run the HashMap version
    public static void runHashMapVersion() {
        ExpenseTrackerHash tracker = new ExpenseTrackerHash();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Expense Tracker (HashMap Version) =====");
            System.out.println("1. Add expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Calculate total expenses");
            System.out.println("4. Find highest expense");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tracker.addExpense();
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    tracker.totalExpenses();
                    break;
                case 4:
                    tracker.highestExpenses();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input, try again\n");
                    break;
            }

        } while (choice != 5);
    }
}