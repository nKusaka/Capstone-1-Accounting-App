package com.accounting;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;

public class HomeScreen {

    // Creates the homescreen for the user
    public static void homeScreen() throws Exception {

        // Initialize variables
        String userInput = "";
        Scanner read = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        boolean isValid = true;
        FileWriter fileWriter = new FileWriter("transactions.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        do {
            if (isValid) {
                System.out.println("""
                        |=====================Home Screen=====================|
                        |              Press D to add a deposit               |
                        |              Press P to make a payment              |
                        |         Press L to display the Ledger screen        |
                        |           Press X to exit the application           |
                        |=====================================================|""");
            }
            System.out.printf("Enter choice: ");
            userInput = read.nextLine();

            // Check to make sure users input is valid
            switch (userInput.toLowerCase()) {
                case "d":
                    addDeposit(read, transactions, formatter, bufferedWriter);
                    isValid = true;
                    break;
                case "p":
                    makePayment(read, bufferedWriter, transactions, formatter);
                    isValid = true;
                    break;
                case "l":
                    displayLedger(read,transactions);
                    isValid = true;
                    break;
                case "x":
                    bufferedWriter.close();
                    break;
                default:
                    isValid = false;
                    System.out.println("This input is invalid");
            }
        } while (!userInput.equalsIgnoreCase("x"));

    }

    // Method adds a users deposit to the transactions.csv file and arraylist/hashmap and creates a new transaction
    public static void addDeposit(Scanner read, ArrayList<Transaction> transactions, DateTimeFormatter formatter, BufferedWriter bufferedWriter) throws Exception {
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
        while (amount < 0 ) {
            System.out.printf("Please enter a valid deposit amount (deposits should be a positive amount): ");
            amount = read.nextDouble();
        }
        read.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDate = dateTime.format(formatter);

        // Create new Transaction object to hold transaction data
        Transaction tempTransaction = new Transaction(formattedDate, description, vendor, amount);
        transactions.add(tempTransaction);

        // Save transaction to csv file
        bufferedWriter.write(String.valueOf(tempTransaction) + "\n");
    }

    // This method adds a loading effect when called
    public static void loadingEffect() throws Exception {
        Thread.sleep(2000);
    }

    // This method allows the user to make a payment
    public static void makePayment(Scanner read, BufferedWriter bufferedWriter, ArrayList<Transaction> transactions, DateTimeFormatter formatter) throws Exception {
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
        while (amount > 0 ) {
            System.out.printf("Please enter a valid payment amount (payments should have a -): ");
            amount = read.nextDouble();
        }
        read.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDate = dateTime.format(formatter);

        // Create new Transaction object to hold transaction data
        Transaction tempTransaction = new Transaction(formattedDate, description, vendor, amount);
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

        //loadingEffect();
        Ledger.ledgerScreen(read,transactions);
    }
}
