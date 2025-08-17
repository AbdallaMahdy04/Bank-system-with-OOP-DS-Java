/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banksystem;

import java.util.*;

public class Admin {
    private String adminID;
    private String encryptedPassword;

    public Admin(String adminID, String password) {
        this.adminID = adminID;
        this.encryptedPassword = encryptPassword(password);
    }

    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public boolean authenticate(String password) {
        return encryptedPassword.equals(encryptPassword(password));
    }

    public void addCustomer(Bank bank, String customerID, String name, String address, double balance, String accountType) {
        bank.createCustomer(customerID, name, address, balance, accountType);
    }

    public void deleteCustomer(Bank bank, String customerID) {
        if (!bank.customers.containsKey(customerID)) {
            throw new NoSuchElementException("Customer not found.");
        }
        bank.customers.remove(customerID);
        System.out.println("Customer deleted successfully.");
    }
}

