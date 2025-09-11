package org.mathiasus.accounts;

import org.mathiasus.persons.customers.Customer;

public class SaveAccount extends BankAccount {

    private float interestRate;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, float interestRate) {
        super(uuid, bankAccountNumber, customer, balance);
        this.interestRate = interestRate;
    }
    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance){
        this(uuid, bankAccountNumber, customer, balance, 0);
    }

    public float getInterestRate() {
        return interestRate;
    }
}
