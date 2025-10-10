package com.accounting;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

public class HomeScreen {

    // Creates the homescreen for the user
    public static void homeScreen() throws Exception {

        String userInput = "";
        Scanner read = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");

        do {
            System.out.printf("""
                                  |=====================Home Screen=====================|
                                  |              Press D to add a deposit               |
                                  |              Press P to make a payment              |
                                  |         Press L to display the Ledger screen        |
                                  |           Press X to exit the application           |
                                  |=====================================================|
                                  Enter command:""");

            userInput = read.nextLine();

            // Check to make sure users input is valid
            while (!userInput.equalsIgnoreCase("d")
                    && !userInput.equalsIgnoreCase("p")
                    && !userInput.equalsIgnoreCase("l")
                    && !userInput.equalsIgnoreCase("x"))
            {
                System.out.printf("Please enter a valid input: ");
                userInput = read.nextLine();
            }
            switch (userInput.toLowerCase()) {
                case "d":
                    addDeposit(read, transactions, formatter);
                    break;
                case "p":
                   // makePayment();
                    break;
                case "l":
                    //displayLedger();
                    break;
            }
        } while (!userInput.equalsIgnoreCase("x"));
    }

    // Method adds a users deposit to the transactions.csv file and arraylist/hashmap and creates a new transaction
    public static void addDeposit(Scanner read, ArrayList<Transaction> transactions, DateTimeFormatter formatter) throws Exception {
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

        System.out.printf("Enter the amount for the transaction (if something was paid for enter a negative number): ");
        double amount = read.nextDouble();
        read.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDate = dateTime.format(formatter);

        // Create new Transaction object to hold transaction data
        transactions.add(new Transaction(formattedDate, description, vendor, amount));

        System.out.println(transactions.get(0));

    }

    // This method adds a loading effect when called
    public static void loadingEffect() throws Exception {
        Thread.sleep(2000);
    }
}
