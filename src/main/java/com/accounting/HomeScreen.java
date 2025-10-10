package com.accounting;
import java.util.*;
import java.io.*;

public class HomeScreen {
    public static void homeScreen() {
        String userInput = "";
        Scanner read = new Scanner(System.in);
        boolean firstLaunch = true;
        do {

            if (firstLaunch) {
                System.out.println("""
                                  |=====================Home Screen=====================|
                                  |              Press D to add a deposit               |
                                  |              Press P to make a payment              |
                                  |         Press L to display the Ledger screen        |
                                  |           Press X to exit the application           |
                                  |=====================================================|""");
                firstLaunch = false;
            }
            userInput = read.nextLine();
        } while (!userInput.equalsIgnoreCase("x"));
    }
}
