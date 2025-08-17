/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banksystem;

import java.util.Date;

public class Transaction implements Comparable<Transaction> {
    private String transactionID;
    private String type;
    private double amount;
    private Date date;
    private String customerID;
    private String senderReceiverID; // For transfers/requests

    public Transaction(String transactionID, String type, double amount, Date date, 
                       String customerID, String senderReceiverID) {
        this.transactionID = transactionID;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.customerID = customerID;
        this.senderReceiverID = senderReceiverID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getSenderReceiverID() {
        return senderReceiverID;
    }

    @Override
    public int compareTo(Transaction other) {
        return other.getDate().compareTo(this.date); // Descending order
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "ID='" + transactionID + '\'' +
                ", Type='" + type + '\'' +
                ", Amount=" + amount +
                ", Date=" + date +
                ", CustomerID='" + customerID + '\'' +
                ", Sender/Receiver='" + senderReceiverID + '\'' +
                '}';
    }
}

