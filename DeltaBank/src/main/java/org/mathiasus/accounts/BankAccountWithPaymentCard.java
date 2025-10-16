package org.mathiasus.accounts;

import org.mathiasus.cards.PaymentCard;
import org.mathiasus.persons.customers.Customer;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static org.mathiasus.storage.PaymentCardStorage.paymentCardMapToAccounts;
import static org.mathiasus.storage.PaymentCardStorage.paymentCardMapToCardNumber;

public abstract class BankAccountWithPaymentCard extends BankAccount {

    private Map<String, PaymentCard> accountPaymentCardMap = new HashMap<>();

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
        accountPaymentCardMap.put(paymentCard.getCardNumber(), paymentCard);
        paymentCardMapToCardNumber.put(paymentCard.getCardNumber(), paymentCard);
        paymentCardMapToAccounts.put(paymentCard.getCardNumber(), this);
    }
    public void removePaymentCard(String cardNumber) {

        accountPaymentCardMap.remove(cardNumber);
        paymentCardMapToCardNumber.remove(cardNumber);
        paymentCardMapToAccounts.put(cardNumber, this);
    }
    public Map<String, PaymentCard> getPaymentCards() {
        return accountPaymentCardMap;
    }

}
