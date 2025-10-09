package org.mathiasus.services.cardManagement;

import org.mathiasus.accounts.BankAccountWithPaymentCard;
import org.mathiasus.cards.PaymentCard;

import java.util.Map;

public class CardManagementService {

    public void addPaymentCard(PaymentCard paymentCard, BankAccountWithPaymentCard account) throws IllegalArgumentException {
        Map<String, PaymentCard> paymentCardMap = account.getPaymentCards();

        if(!paymentCardMap.containsKey(paymentCard.getCardNumber())) {
            account.addPaymentCard(paymentCard);
        }else {
            throw  new IllegalArgumentException("Duplicate card number, unable to add payment card");
        }
    }
    public void removePaymentCard(String cardNumber, BankAccountWithPaymentCard account) throws IllegalArgumentException {
        Map<String, PaymentCard> paymentCardMap = account.getPaymentCards();

        if(paymentCardMap.containsKey(cardNumber)) {
            account.removePaymentCard(cardNumber);
        }else{
            throw new IllegalArgumentException("Invalid card number, card doesn't exist for this account");
        }
    }

}
