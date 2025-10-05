package org.mathiasus.accounts;

import org.mathiasus.persons.customers.Customer;

public abstract class BankAccount {

    private final String uuid;
    private final String bankAccountNumber;
    private final Customer customer;
    protected double balance;
    // If limit is negative, it behaves like no limit exists
    protected double perPaymentLimit;
    // If limit is negative, it behaves like no limit exists
    protected double monthlyLimit;
    protected double monthlySpentBalance;
    protected double monthlyDepositedBalance;

    public BankAccount(String uuid, String bankAccountNumber, Customer customer, double balance,  double perPaymentLimit, double monthlyLimit) {

        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
        this.perPaymentLimit = perPaymentLimit;
        this.monthlyLimit = monthlyLimit;
    }
    public BankAccount() {
        this.uuid = null;
        this.bankAccountNumber = null;
        this.customer = null;
    }
    public BankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {

        this(uuid, bankAccountNumber, customer, balance, -1.0f, -1.0f);
    }

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public double getPerPaymentLimit() {
        return perPaymentLimit;
    }

    public double getMonthlySpentBalance() {
        return monthlySpentBalance;
    }

    public double getMonthlyDepositedBalance() {
        return monthlyDepositedBalance;
    }

    public void setMonthlyDepositedBalance(double monthlyDepositedBalance) {
        this.monthlyDepositedBalance = monthlyDepositedBalance;
    }

    public void setMonthlySpentBalance(double balance) {
        this.monthlySpentBalance = balance;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
