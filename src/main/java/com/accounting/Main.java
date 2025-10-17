package com.accounting;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Variables that will be used in the program
        Scanner read = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("transactions.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Transaction> transactions = loadArrayList(bufferedReader);


        // Starts program from welcome screen
        DisplayScreens.welcomeScreen(transactions, bufferedWriter, read);

        // Close Scanners, buffers, and filewriters/readers
        read.close();
        bufferedWriter.close();
        bufferedReader.close();
        fileWriter.close();
        fileReader.close();
    }

    // Method loads the array list that will be passed around
    public static ArrayList<Transaction> loadArrayList(BufferedReader bufferedReader) throws IOException {

        // Create new arraylist and formatter
        ArrayList<Transaction> loadTransactions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        String input;

        // Read the file
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionData = input.split("\\|");

            // Converts string input from file to data that can be used to create new Transaction objects
            String dateTime = (transactionData[0] + "|" + transactionData[1]);
            String description = transactionData[2];
            String vendor = transactionData[3];
            double amount = Double.parseDouble(transactionData[4]);
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);

            loadTransactions.add(new Transaction(localDateTime, description, vendor, amount));

        }

        return loadTransactions;
    }
}
