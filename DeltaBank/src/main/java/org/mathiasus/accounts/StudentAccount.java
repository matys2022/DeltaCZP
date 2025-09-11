package org.mathiasus.accounts;

import org.mathiasus.models.facilities.education.School;
import org.mathiasus.persons.customers.Customer;

public class StudentAccount extends BankAccount {

    private School school;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, double balance, School school) {
        super(uuid, bankAccountNumber, customer, balance);
        this.school = school;
    }
    public School getSchool() {
        return school;
    }

}
