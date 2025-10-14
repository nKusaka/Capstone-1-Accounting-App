package com.accounting;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class Transaction {

    // Initialize instance variables
    private String dateTime;
    private String description;
    private String vendor;
    private double amount;
    private String debitInformation;

    // Constructors parameterized and default
    public Transaction(String dateTime, String description, String vendor, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction () {

    }

    // Setters
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDebitInformation(String debitInformation) {
        this.debitInformation = debitInformation;
    }

    // Getters
    public String getDateTime() {
        return this.dateTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVendor() {
        return this.vendor;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDebitInformation() {
        return this.debitInformation;
    }

    @Override
    public String toString() {
        return this.dateTime + "|" + this.description + "|" + this.vendor + "|" + this.amount;
    }
}
