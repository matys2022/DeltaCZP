package org.mathiasus.accounts;

import org.mathiasus.cards.PaymentCard;
import org.mathiasus.persons.customers.Customer;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public abstract class BankAccountWithPaymentCard extends BankAccount {

    private Map<String, PaymentCard> paymentCardMap = new HashMap<>();

    public BankAccountWithPaymentCard(String uuid, String bankAccountNumber, Customer customer, double balance, double perPaymentLimit, double monthlyLimit) {
        super(uuid, bankAccountNumber, customer, balance, perPaymentLimit, monthlyLimit);
    }

    public BankAccountWithPaymentCard(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this(uuid, bankAccountNumber, customer, balance, -1.0f, -1.0f);
    }

    public BankAccountWithPaymentCard() {
        super();
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        paymentCardMap.put(paymentCard.getCardNumber(), paymentCard);
    }
    public void removePaymentCard(String cardNumber) {
        paymentCardMap.remove(cardNumber);
    }
    public Map<String, PaymentCard> getPaymentCards() {
        return paymentCardMap;
    }

}
