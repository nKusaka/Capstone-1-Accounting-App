package com.accounting;
import java.util.*;
import java.io.*;

public class HomeScreen {
    public static void homeScreen() {

        String userInput = "";
        Scanner read = new Scanner(System.in);

        do {
            System.out.printf("""
                                  |=====================Home Screen=====================|
                                  |              Press D to add a deposit               |
                                  |              Press P to make a payment              |
                                  |         Press L to display the Ledger screen        |
                                  |           Press X to exit the application           |
                                  |=====================================================|
                                  Enter command:""");

            userInput = read.nextLine();

            while (!userInput.equalsIgnoreCase("d") && !userInput.equalsIgnoreCase("p") && !userInput.equalsIgnoreCase("l") && !userInput.equalsIgnoreCase("x")) {
                System.out.printf("Please enter a valid input: ");
                userInput = read.nextLine();
            }
         /*   switch (userInput.toLowerCase()) {
                case "d":
                    addDeposit();
                    break;
                case "p":
                    makePayment();
                    break;
                case "l":
                    displayLedger();
                    break;
            }*/
        } while (!userInput.equalsIgnoreCase("x"));
    }
}
