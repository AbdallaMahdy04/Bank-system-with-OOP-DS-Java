/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banksystem;

import java.util.*;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private double balance;
    private String accountType; // Savings or Current
    private PriorityQueue<Transaction> transactionHistory;

    public Customer(String customerID, String name, String address, double balance, String accountType) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionHistory = new PriorityQueue<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
        transactionHistory.add(new Transaction(UUID.randomUUID().toString(), "Deposit", amount, new Date(), customerID, null));
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
        transactionHistory.add(new Transaction(UUID.randomUUID().toString(), "Withdrawal", amount, new Date(), customerID, null));
    }

    public void transfer(Customer receiver, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        this.withdraw(amount);
        receiver.deposit(amount);
        transactionHistory.add(new Transaction(UUID.randomUUID().toString(), "Transfer", amount, new Date(), customerID, receiver.getCustomerID()));
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for Customer: " + customerID);
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + customerID + '\'' +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Balance=" + balance +
                ", Account Type='" + accountType + '\'' +
                '}';
    }
}

