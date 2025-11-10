package org.mathiasus.factories;

import org.mathiasus.accounts.BankAccountActivityType;
import org.mathiasus.accounts.BankAccountTransaction;


public class BankAccountTransactionFactory {
    public BankAccountTransactionFactory() {

    }

    public BankAccountTransaction createBankAccountTransaction(BankAccountActivityType activity, Double amount) {
        return new BankAccountTransaction(activity, amount);
    }
}
