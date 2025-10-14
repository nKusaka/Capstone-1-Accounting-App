package com.accounting;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;

public class Ledger {

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
                    isValid = true;
                    break;
                case "p":
                    isValid = true;
                    break;
                case "r":
                    break;
                case "h":
                    System.out.printf("""
                ======================================
                Returning to Home Screen.....
                ======================================\n""");
                    HomeScreen.loadingEffect();
                    break;
                default:
                    isValid = false;
                    System.out.println("This input is invalid");
            }
        } while (!userInput.equalsIgnoreCase("h"));
    }

    // This method shows the user all of their account transactions
    public static void displayAllEntries(ArrayList<Transaction> transactions) throws Exception {

        System.out.printf("""
                ======================================
                Displaying all Entries.....
                ======================================\n""");
        HomeScreen.loadingEffect();

        for (int i = transactions.size(); i > 0; --i) {
            System.out.println(transactions.get(i));
        }
    }
}
