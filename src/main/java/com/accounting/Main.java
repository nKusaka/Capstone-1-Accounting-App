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
        ArrayList<Transaction> transactions = new ArrayList<>();
        FileWriter fileWriter = new FileWriter("transactions.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Loads the array list that will be passed around in the program
        transactions = loadArrayList(transactions, bufferedReader);

        // Starts program from welcome screen
        DisplayScreens.welcomeScreen(transactions, bufferedWriter, read);

        read.close();
        bufferedWriter.close();
        bufferedReader.close();
        fileWriter.close();
        fileReader.close();
    }

    // Method loads the array list that will be passed around
    public static ArrayList<Transaction> loadArrayList(ArrayList<Transaction> transactions, BufferedReader bufferedReader) throws IOException {

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionData = input.split("\\|");

            LocalDateTime dateTime =
        }
        bufferedReader.close();
        return transactions;
    }
}
