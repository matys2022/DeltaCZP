package org.mathiasus.accounts;

import org.mathiasus.persons.customers.Customer;

public class RegularAccount extends BankAccountWithPaymentCard {
    public RegularAccount() {}

    public RegularAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);
    }
}
