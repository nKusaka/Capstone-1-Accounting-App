package com.accounting;
import static com.accounting.HomeScreenOptions.*;
import static com.accounting.LedgerOptions.*;
import static com.accounting.ReportsOptions.*;
import java.time.format.*;
import java.util.*;
import java.io.*;


public class DisplayScreens {

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
                    addDeposit(read, transactions, bufferedWriter);
                    isValid = true;
                    break;
                case "p":
                    makePayment(read, bufferedWriter, transactions);
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

    // This method creates the ledger screen and gets user input
    public static void ledgerScreen(Scanner read, ArrayList<Transaction> transactions) throws Exception {

        // Initialize variables
        boolean isValid = true;
        String userInput = "";

        // Print ledger screen
        do {
            if (isValid) {

                System.out.println("""
                        |=====================Ledger Screen=====================|
                        |            Press A to display all entries             |
                        |              Press D to show deposits                 |
                        |             Press P to show payments made             |
                        |           Press R to see the reports screen           |
                        |         Press H to return to the home screen          |
                        |=======================================================|""");
            }
            System.out.printf("Enter choice: ");
            userInput = read.nextLine();

            // Check to make sure users input is valid
            switch (userInput.toLowerCase()) {
                case "a":
                    displayAllEntries(transactions);
                    isValid = true;
                    break;
                case "d":
                    displayDeposits(transactions);
                    isValid = true;
                    break;
                case "p":
                    displayPayments(transactions);
                    isValid = true;
                    break;
                case "r":
                    userInput = displayReports(transactions, read);
                    isValid = true;
                    break;
                case "h":
                    System.out.printf("""
                ======================================
                Returning to Home Screen.....
                ======================================\n""");
                    HomeScreenOptions.loadingEffect();
                    break;
                default:
                    isValid = false;
                    System.out.println("This input is invalid");
            }
        } while (!userInput.equalsIgnoreCase("h"));
    }

    // Reports Screen
    public static String reportsScreen(ArrayList<Transaction> transactions, Scanner read) throws Exception {
        // Initialize variables
        boolean isValid = true;
        String userInput = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");

        // Print ledger screen
        do {
            if (isValid) {

                System.out.println("""
                        |=====================Reports Screen=====================|
                        |           Press 1 for Month to Date Report             |
                        |          Press 2 for Previous Month's Reports          |
                        |             Press 3 for Year to Date Report            |
                        |            Press 4 for Previous Years Report           |
                        |               Press 5 to Search by Vendor              |
                        |               Press 0 for the Ledger Menu              |
                        |          Press H to go back to the homescreen          |
                        |========================================================|""");
            }
            System.out.printf("Enter choice: ");
            userInput = read.nextLine();

            // Check to make sure users input is valid
            switch (userInput.toLowerCase()) {
                case "1":
                    showMonthToDate(transactions);
                    isValid = true;
                    break;
                case "2":
                    showPreviousMonth(transactions);
                    isValid = true;
                    break;
                case "3":
                    showYearToDate(transactions);
                    isValid = true;
                    break;
                case "4":
                    showPreviousYear(transactions);
                    isValid = true;
                    break;
                case "5":
                    vendorSearch(transactions, read);
                    isValid = true;
                    break;
                case "0":
                    System.out.printf("""
                ======================================
                Returning to Ledger Screen.....
                ======================================\n""");
                    break;
                case "h":
                    System.out.printf("""
                ======================================
                Returning to Home Screen.....
                ======================================\n""");
                    break;
                default:
                    isValid = false;
                    System.out.println("This input is invalid");
            }
        } while (!userInput.equalsIgnoreCase("h") && !userInput.equals("0"));
        HomeScreenOptions.loadingEffect();
        return userInput;
    }
}
