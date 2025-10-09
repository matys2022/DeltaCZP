package org.mathiasus.factories;

import org.mathiasus.cards.CreditCard;
import org.mathiasus.cards.DebitCard;
import org.mathiasus.cards.PaymentCard;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.utilities.generation.CardGeneration;

import java.util.Date;

public class PaymentCardFactory {

    private CardGeneration cardGeneration;

    public PaymentCardFactory(){
        this.cardGeneration = new CardGeneration();
    }

    public PaymentCard createCreditPaymentCard(Customer customer, String expirationMonth, String expirationYear,  double lineOfCreditLimit, double interestRate, Date minimumPaymentDue){
        return new CreditCard(cardGeneration.generateUUID(), customer, cardGeneration.generateAccountNumber(), cardGeneration.generateCardCVV(), expirationMonth, expirationYear, lineOfCreditLimit, interestRate, minimumPaymentDue);
    }
    public PaymentCard createDebitPaymentCard(Customer customer, String expirationMonth, String expirationYear, double fee){
        return new DebitCard(cardGeneration.generateUUID(), customer, cardGeneration.generateAccountNumber(), cardGeneration.generateCardCVV(), expirationMonth, expirationYear, fee);
    }
}
