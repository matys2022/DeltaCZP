package org.mathiasus.factories;

import com.google.inject.Inject;
import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.accounts.StudentAccount;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.storage.BankAccountStorage;
import org.mathiasus.storage.BankLogStorage;
import org.mathiasus.utilities.generation.AccountCreation;

public class BankAccountFactory {

    @Inject
    private AccountCreation accountHelper;


    public BankAccountFactory() {}

    public  BankAccount createRegularAccount(Customer customer, double balance) {
        BankAccount bankAccount = new RegularAccount(accountHelper.CreateBankAccountUUID(), accountHelper.CreateAccountNumber(), customer, balance);
        addBankAccount(bankAccount);
        return bankAccount;
    }
    public  BankAccount createStudentAccount(Customer customer, double balance, School school) {
        BankAccount bankAccount = new StudentAccount(accountHelper.CreateBankAccountUUID(), accountHelper.CreateAccountNumber(), customer, balance, school);
        addBankAccount(bankAccount);
        return bankAccount;
    }
    public  BankAccount createSaveAccount(Customer customer, double balance, float interestRate) {
        BankAccount bankAccount = new SaveAccount(accountHelper.CreateBankAccountUUID(), accountHelper.CreateAccountNumber(), customer, balance, interestRate);
        addBankAccount(bankAccount);
        return bankAccount;
    }
    private void addBankAccount(BankAccount bankAccount) {
        BankAccountStorage.accountNumberToBankAccount.add(bankAccount);
    }

}
