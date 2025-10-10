package com.accounting;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class Transaction {

    // Initialize instance variables
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;

    // Constructors parameterized and default
    public Transaction(LocalDateTime dateTime, String description, String vendor, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction () {

    }

    // Setters
    public void setDateTime(LocalDateTime dateTime) {
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

    // Getters
    public LocalDateTime getDateTime() {
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

    @Override
    public String toString() {
        return this.dateTime + " " + this.description + " " + this.vendor + " $" + this.amount;
    }
}
