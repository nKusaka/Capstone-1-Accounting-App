package com.accounting;
import java.time.*;
import java.util.*;
import java.io.*;

public class HomeScreenOptions {

    // Method adds a users deposit to the transactions.csv file and arraylist/hashmap and creates a new transaction
    public static void addDeposit(Scanner read, ArrayList<Transaction> transactions, BufferedWriter bufferedWriter) throws Exception {
        System.out.printf("""
                ======================================
                Accessing Deposit Menu.....
                ======================================\n""");

        //loadingEffect();

        // Get user input for the transaction
        System.out.printf("Enter a description of the transaction: ");
        String description = read.nextLine();

        System.out.printf("Enter the vendor name: ");
        String vendor = read.nextLine();

        System.out.printf("Enter the deposit amount: ");
        double amount = read.nextDouble();
        while (amount <= 0 ) {
            System.out.printf("Please enter a valid deposit amount (deposits should be a positive amount): ");
            amount = read.nextDouble();
        }
        read.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();

        // Create new Transaction object to hold transaction data
        Transaction tempTransaction = new Transaction(dateTime, description, vendor, amount);
        transactions.add(tempTransaction);

        // Save transaction to csv file
        bufferedWriter.write(String.valueOf(tempTransaction) + "\n");
    }

    // This method adds a loading effect when called
    public static void loadingEffect() throws Exception {
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.printf("▌");
            }
        Thread.sleep(1000);
        System.out.println();
        }

    // This method allows the user to make a payment
    public static void makePayment(Scanner read, BufferedWriter bufferedWriter, ArrayList<Transaction> transactions) throws Exception {
        System.out.printf("""
                ======================================
                Accessing Payment Menu.....
                ======================================\n""");

        //loadingEffect();

        // Get user input for the transaction
        System.out.printf("Enter a description of the transaction: ");
        String description = read.nextLine();

        System.out.printf("Enter the vendor name: ");
        String vendor = read.nextLine();

        System.out.printf("Enter the payment amount: ");
        double amount = read.nextDouble();
        while (amount >= 0 ) {
            System.out.printf("Please enter a valid payment amount (payments should have a -): ");
            amount = read.nextDouble();
        }
        read.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();

        // Create new Transaction object to hold transaction data
        Transaction tempTransaction = new Transaction(dateTime, description, vendor, amount);
        transactions.add(tempTransaction);

        // Save transaction to csv file
        bufferedWriter.write(String.valueOf(tempTransaction) + "\n");
    }

    // This method allows the user to see the Ledger screen
    public static void displayLedger(Scanner read, ArrayList<Transaction> transactions) throws Exception {
        System.out.printf("""
                ======================================
                Fetching Ledger Screen.....
                ======================================\n""");

       // loadingEffect();
        DisplayScreens.ledgerScreen(read,transactions);
    }
}
