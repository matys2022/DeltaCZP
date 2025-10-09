package org.mathiasus.cards;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.persons.customers.Customer;

public abstract class PaymentCard {

    private String uuid;
    private Customer customer;
    private String cardNumber;
    private String cvv;
    private String expirationMonth;
    private String expirationYear;

    public PaymentCard(){}

    public PaymentCard(String uuid, Customer customer, String cardNumber, String cvv, String expirationMonth, String expirationYear) {
        this.uuid = uuid;
        this.customer = customer;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getUuid() {
        return uuid;
    }

    public Customer getCustomer() {
        return customer;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }
}
