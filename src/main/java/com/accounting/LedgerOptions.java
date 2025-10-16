package com.accounting;
import java.util.*;

public class LedgerOptions {

    // This method shows the user all of their account transactions
    public static void displayAllEntries(ArrayList<Transaction> transactions) throws Exception {

        System.out.printf("""
                ======================================
                Displaying all Entries.....
                ======================================\n""");

        if (!transactions.isEmpty()) {
        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i));
        }
        } else {
            System.out.println("There are currently no transactions to list");
        }
    }

    // This method shows only deposits made into the account (positive transactions)
    public static void displayDeposits(ArrayList<Transaction> transactions) throws Exception {
        System.out.printf("""
                ======================================
                Displaying all Deposits.....
                ======================================\n""");

        if (!transactions.isEmpty()) {
            for (int i = transactions.size() - 1; i >= 0; i--) {
                if (transactions.get(i).getAmount() > 0) {
                    System.out.println(transactions.get(i));
                }
            }
        } else {
            System.out.println("There are currently no deposits to list");
        }
    }

    // This method shows only payments made by the account (negative transactions)
    public static void displayPayments(ArrayList<Transaction> transactions) throws Exception {
        System.out.printf("""
                ======================================
                Displaying all Payments.....
                ======================================\n""");

        if (!transactions.isEmpty()) {
            for (int i = transactions.size() - 1; i >= 0; i--) {
                if (transactions.get(i).getAmount() < 0) {
                    System.out.println(transactions.get(i));
                }
            }
        } else {
            System.out.println("There are currently no payments to list");
        }
    }

    // This method takes the user to the reports menu
    public static String displayReports(ArrayList<Transaction> transactions, Scanner read) throws Exception {
        System.out.printf("""
                ======================================
                Fetching Reports Screen.....
                ======================================\n""");
       HomeScreenOptions.loadingEffect();

        return DisplayScreens.reportsScreen(transactions, read);
    }
}