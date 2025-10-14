package com.accounting;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;

public class Reports {
    public static String reportsScreen(ArrayList<Transaction> transactions, Scanner read) {
        // Initialize variables
        boolean isValid = true;
        String userInput = "";

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
                case "a":
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
                    return userInput.toLowerCase();
                    break;
                default:
                    isValid = false;
                    System.out.println("This input is invalid");
            }
        } while (!userInput.equalsIgnoreCase("h"));
    }
    }
}
