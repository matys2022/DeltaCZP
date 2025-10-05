package org.mathiasus.serialization.accounts;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.persons.customers.Customer;

public abstract class BankAccountSerialization {
    public String uuid;
    public String bankAccountNumber;
    public Customer customer;
    public double balance;
    // If limit is negative, it behaves like no limit exists
    public double perPaymentLimit;
    // If limit is negative, it behaves like no limit exists
    public double monthlyLimit;
    public double monthlySpentBalance;
    public double monthlyDepositedBalance;

    public BankAccountSerialization(BankAccount RegularAccount) {
        uuid = RegularAccount.getUuid();
        bankAccountNumber = RegularAccount.getBankAccountNumber();
        customer = RegularAccount.getCustomer();
        balance = RegularAccount.getBalance();
        perPaymentLimit = RegularAccount.getPerPaymentLimit();
        monthlyLimit = RegularAccount.getMonthlyLimit();
        monthlySpentBalance = RegularAccount.getMonthlySpentBalance();
        monthlyDepositedBalance = RegularAccount.getMonthlyDepositedBalance();
    }
}
