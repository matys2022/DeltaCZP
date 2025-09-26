package org.mathiasus;

import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.accounts.StudentAccount;
import org.mathiasus.factories.BankAccountFactory;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.models.facilities.enums.FaciltityType;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.services.balanceManagement.BalanceManagementService;
import javax.naming.OperationNotSupportedException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("c-222", "John", "", "Middleman");
        School school = new School("6332340273", "Gymnazium jana capka", "Praha 8", "janacapka@example.com", FaciltityType.School);

        BankAccountFactory factory = new BankAccountFactory();

        BankAccount account0 = factory.createRegularAccount(customer, 123);
        BankAccount account1 = factory.createSaveAccount(customer, 123, 0.1f);
        BankAccount account2 = factory.createStudentAccount(customer, 123, school);


        try{
            testAccount(account0);
            testAccount(account1);
            testAccount(account2);


        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }


    public static void testAccount(BankAccount account) throws OperationNotSupportedException {

        printAccount(account);

        BalanceManagementService balanceManagementService = new BalanceManagementService(account);

        BankAccount bankAccountModified = balanceManagementService.getAccount();

        balanceManagementService.deposit( 250);

//        bankAccountModified = balanceManagementService.getAccount();
        printAccount(bankAccountModified);

        balanceManagementService.withdraw(250);
//        bankAccountModified = balanceManagementService.getAccount();

        printAccount(bankAccountModified);




        switch (bankAccountModified){
            case  RegularAccount BankAccount:
                break;
            case  SaveAccount BankAccount:
                System.out.println(String.format("Next month increase will be approximately %f", BankAccount.getBalance() * BankAccount.getInterestRate()));
                break;
            case  StudentAccount BankAccount:
                Customer customer = BankAccount.getCustomer();
                School school = BankAccount.getSchool();
                System.out.println("Owner of this bank account named " + customer.getFirstName()+ " " + customer.getLastName() + " is a student of " + school.getFacilityName());
                break;
            default:
                throw new OperationNotSupportedException("Account type not implemented yet!");
        }
    }
    public static void printAccount(BankAccount account){
        Customer customer = account.getCustomer();
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + ": " +  account.getBalance());
    }
}