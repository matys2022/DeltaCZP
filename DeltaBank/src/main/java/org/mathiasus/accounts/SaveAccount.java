package org.mathiasus.accounts;

import org.mathiasus.persons.customers.Customer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class SaveAccount extends BankAccountWithPaymentCard {

    private final float interestRate;
    private final boolean monthly;
    private LocalDateTime nextTerm;

    public SaveAccount(){
        this.interestRate = 0.0f;
        this.monthly = false;
        this.nextTerm = LocalDateTime.now().plusMonths((12));
    }
    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, float interestRate,  boolean isMonthly) {
        super(uuid, bankAccountNumber, customer, balance);
        this.interestRate = interestRate;
        this.monthly = isMonthly;
        this.nextTerm = LocalDateTime.now().plusMonths((isMonthly?1:12));
    }
    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, float interestRate) {
        this(uuid, bankAccountNumber, customer, balance, interestRate, true);
    }
    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance){
        this(uuid, bankAccountNumber, customer, balance, 0);
    }

    public float getInterestRate() {
        return interestRate;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public LocalDateTime getNextTerm() {
        return nextTerm;
    }
    public void setNextTerm(LocalDateTime nextTerm) {
        this.nextTerm = nextTerm;
    }
}
