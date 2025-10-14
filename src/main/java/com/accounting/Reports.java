package com.accounting;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Reports {
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
                    showMonthToDate(transactions, formatter);
                    isValid = true;
                    break;
                case "2":
                    isValid = true;
                    break;
                case "3":
                    isValid = true;
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "0":
                    break;
                case "h":
                    break;
                default:
                    isValid = false;
                    System.out.println("This input is invalid");
            }
        } while (!userInput.equalsIgnoreCase("h") && !userInput.equals("0"));

        return userInput;
    }

    public static void showMonthToDate(ArrayList<Transaction> transactions, DateTimeFormatter formatter) throws Exception{

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime firstOfMonth = today.withDayOfMonth(1);

        List<Transaction> monthToDateTransactions = transactions.stream().filter
                (transaction -> transaction.getDateTime().isBefore(today)
        && transaction.getDateTime().isAfter(firstOfMonth))
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed()).toList();

        monthToDateTransactions.forEach(transaction -> System.out.println(transaction));

    }
}
