package org.mathiasus.serialization.accounts;

import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.persons.customers.Customer;

public class SaveAccountSerialization extends  BankAccountSerialization{
    public float interestRate;

    public SaveAccountSerialization(SaveAccount bankAccount){

        super(bankAccount);
        interestRate = bankAccount.getInterestRate();
    }
}
