package org.mathiasus.cards;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.persons.customers.Customer;

import java.util.Date;

public class CreditCard extends PaymentCard {
    private double lineOfCreditLimit;
    private double interestRate;
    private Date minimumPaymentDue;

    public CreditCard(String uuid, Customer customer, String cardNumber, String cvv, String expirationMonth, String expirationYear, double lineOfCreditLimit, double interestRate, Date minimumPaymentDue){
        super(uuid, customer, cardNumber, cvv, expirationMonth, expirationYear);
        this.lineOfCreditLimit = lineOfCreditLimit;
        this.interestRate = interestRate;
        this.minimumPaymentDue = minimumPaymentDue;
    }
    public CreditCard(){
        this.lineOfCreditLimit = 0;
        this.interestRate = 0;
        this.minimumPaymentDue = null;
    }
}
