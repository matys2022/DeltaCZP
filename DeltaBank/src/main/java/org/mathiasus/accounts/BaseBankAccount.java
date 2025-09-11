package org.mathiasus.accounts;

import org.mathiasus.persons.customers.Customer;

public class BaseBankAccount {

    private final String uuid;
    private final String bankAccountNumber;
    private final Customer customer;
    private double balance;
    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public boolean removeBalance(double balance) {
        if(this.balance - balance <= 0) {
            System.out.println("Unable to remove balance, not enough balance on the account.");
            return false;
        }else{
            this.balance -= balance;
            System.out.println("Balance: " + balance + " removed.");
            return true;
        }

    }

}
