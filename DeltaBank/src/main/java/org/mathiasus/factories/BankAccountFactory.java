package org.mathiasus.factories;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.accounts.StudentAccount;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.utilities.generation.AccountCreation;

public class BankAccountFactory {

    private static AccountCreation accountHelper = new AccountCreation();



    public BankAccountFactory() {}

    public  BankAccount createRegularAccount(Customer customer, double balance) {
        BankAccount bankAccount = new RegularAccount(accountHelper.CreateBankAccountUUID(), accountHelper.CreateAccountNumber(), customer, balance);
        return bankAccount;
    }
    public  BankAccount createStudentAccount(Customer customer, double balance, School school) {
        BankAccount bankAccount = new StudentAccount(accountHelper.CreateBankAccountUUID(), accountHelper.CreateAccountNumber(), customer, balance, school);
        return bankAccount;
    }
    public  BankAccount createSaveAccount(Customer customer, double balance, float interestRate) {
        BankAccount bankAccount = new SaveAccount(accountHelper.CreateBankAccountUUID(), accountHelper.CreateAccountNumber(), customer, balance, interestRate);
        return bankAccount;
    }

}
