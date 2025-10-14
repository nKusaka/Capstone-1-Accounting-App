package com.accounting;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Reports {

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

    // Method shows the transactions from the current day to the 1st of this month
    public static void showMonthToDate(ArrayList<Transaction> transactions) {

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime firstOfMonth = today.withDayOfMonth(1);

        List<Transaction> monthToDateTransactions = transactions.stream().filter
                (transaction -> !transaction.getDateTime().isAfter(today)
        && !transaction.getDateTime().isBefore(firstOfMonth))
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed()).toList();

        if (!monthToDateTransactions.isEmpty()) {
            monthToDateTransactions.forEach(transaction -> System.out.println(transaction));
        } else {
            System.out.println("There are no transactions this month");
        }
    }

    // Method shows the previous months transactions
    public static void showPreviousMonth(ArrayList<Transaction> transactions) {

        LocalDateTime startOfMonth = LocalDateTime.now().minusMonths(1).withDayOfMonth(1);
        LocalDateTime endOfMonth = LocalDateTime.now().withDayOfMonth(1).minusDays(1);

        List<Transaction> previousMonthTransactions = transactions.stream().filter
                (transaction -> !transaction.getDateTime().isBefore(startOfMonth)
                && !transaction.getDateTime().isAfter(endOfMonth))
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed()).toList();

        if (!previousMonthTransactions.isEmpty()) {
            previousMonthTransactions.forEach(transaction -> System.out.println(transaction));
        } else {
            System.out.println("There are no transactions for the previous month");
        }
    }

    // Method shows the transactions from the current day to the beginning of this year
    public static void showYearToDate(ArrayList<Transaction> transactions) {
        LocalDateTime startOfYear = LocalDateTime.now().withDayOfYear(1);
        LocalDateTime today = LocalDateTime.now();

        List<Transaction> yearToDateTransactions = transactions.stream().filter
                (transaction -> !transaction.getDateTime().isBefore(startOfYear)
                && !transaction.getDateTime().isAfter(today))
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed()).toList();

        if (!yearToDateTransactions.isEmpty()) {
            yearToDateTransactions.forEach(transaction -> System.out.println(transaction));
        } else {
            System.out.println("There are no transactions this year");
        }
    }

    // Method shows the transactions from the previous year
    public static void showPreviousYear(ArrayList<Transaction> transactions) {
        LocalDateTime endOfYear = LocalDateTime.now().withDayOfYear(1);
        LocalDateTime startOfYear = LocalDateTime.now().minusYears(1).withDayOfYear(1);

        List<Transaction> previousYearTransactions = transactions.stream().filter
                (transaction -> !transaction.getDateTime().isBefore(startOfYear)
                && !transaction.getDateTime().isAfter(endOfYear))
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed()).toList();

        if (!previousYearTransactions.isEmpty()) {
            previousYearTransactions.forEach(transaction -> System.out.println(transaction));
        } else {
            System.out.println("There are no transactions for the previous year");
        }
    }

    // Method lets the user search transactions by vendor name
    public static void vendorSearch(ArrayList<Transaction> transactions, Scanner read) {
        System.out.printf("Enter the name of the vendor you would like to search for: ");
        String userInput = read.nextLine().toLowerCase();

        List<Transaction> vendorSearch = transactions.stream().filter
                (transaction -> transaction.getVendor().toLowerCase().contains(userInput)).
                sorted(Comparator.comparing(Transaction::getDateTime).reversed()).toList();

        if (!vendorSearch.isEmpty()) {
            vendorSearch.forEach(transaction -> System.out.println(transaction));
        } else {
            System.out.println("There are no transactions matching your filters");
        }
    }
}
