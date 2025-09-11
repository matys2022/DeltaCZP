package org.mathiasus.accounts;

import org.mathiasus.persons.customers.Customer;

public class BankAccount extends BaseBankAccount{
    public BankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);
    }
}
