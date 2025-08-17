/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banksystem;
import java.util.*;

/**
 *
 * @author user
 */
public class BankSystem {

    public static void main(String[] args) {
        Bank bank = new Bank("QNB", "110 xyz St", "IFSC123");
        Admin admin = new Admin("adminX", "password");

        // creating customers
        admin.addCustomer(bank, "C001", "abdalla", "Address 1", 5000, "Savings");
        admin.addCustomer(bank, "C002", "karim", "Address 2", 3000, "Current");

        Customer abdalla= bank.searchCustomer("C001");
        Customer karim = bank.searchCustomer("C002");

        // transactons
        abdalla.deposit(1000);
        abdalla.withdraw(500);
        abdalla.transfer(karim, 2000);

        System.out.println("\nabdalla's Transaction History:");
        abdalla.displayTransactionHistory();

        System.out.println("\nkarim's Transaction History:");
        karim.displayTransactionHistory();
       
        System.out.println("karim account:\n"+karim.toString());

        System.out.println("abdalla acount\n"+abdalla.toString());


    }
}

