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
                System.out.println("|=====================Home Screen=====================|\n"
                        +          "|           Press D to add a deposit                  |\n"
                        +          "|           Press P to make a payment                 |\n"
                        +          "|       Press L to display the Ledger screen          |\n"
                        +          "|=====================================================|");
                firstLaunch = false;
            }
            userInput = read.nextLine();
        } while (!userInput.equalsIgnoreCase("x"));
    }
}
