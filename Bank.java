/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banksystem;

import java.util.*;

public class Bank {
    private String name;
    private String address;
    private String ifscCode;
    public TreeMap<String, Customer> customers;

    public Bank(String name, String address, String ifscCode) {
        this.name = name;
        this.address = address;
        this.ifscCode = ifscCode;
        this.customers = new TreeMap<>();
    }

    public void createCustomer(String customerID, String name, String address, double balance, String accountType) {
        if (customers.containsKey(customerID)) {
            throw new IllegalArgumentException("Customer ID already exists.");
        }
        customers.put(customerID, new Customer(customerID, name, address, balance, accountType));
        System.out.println("Customer created successfully.");
    }

    public Customer searchCustomer(String customerID) {
        if (!customers.containsKey(customerID)) {
            throw new NoSuchElementException("Customer not found.");
        }
        return customers.get(customerID);
    }

    public void displayAllCustomers() {
        System.out.println("All Customers:");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }

    public void displayBankDetails() {
        System.out.println("Bank Details:");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("IFSC Code: " + ifscCode);
    }
}

