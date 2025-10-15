package com.accounting;
import java.time.*;
import java.util.*;
import java.time.format.*;

public class ReportsOptions {

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

    // Method that lets the user make a custom search
    public static void customSearch(ArrayList<Transaction> transactions, Scanner read, DateTimeFormatter formatter) {


        System.out.printf("Enter a start date of the form (Month Number/Day Number/Year) or press enter to leave blank: ");
        String startDate = read.nextLine();
        if (startDate != null) {

        }

        System.out.printf("Enter an end date of the form (Month Number/Day Number/Year) or press enter to leave blank: ");
        String endDate = read.nextLine();
        if (endDate != null) {

        }

        System.out.printf("Enter a description of what you are looking for or press enter to leave blank: ");
        String description = read.nextLine();
        if (description != null) {

        }

        System.out.printf("Enter the name of the vendor you would like to search for or leave blank: ");
        String vendor = read.nextLine();
        if (vendor != null) {

        }

        System.out.printf("Enter an amount (DO NOT USE $) you would like to search for or leave blank: ");
        double amount = read.nextDouble();
        read.nextLine();
        if (amount != 0) {

        }


    }
}
