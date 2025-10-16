package org.mathiasus.storage;

import org.mathiasus.accounts.BankAccountWithPaymentCard;
import org.mathiasus.cards.PaymentCard;

import java.util.HashMap;
import java.util.Map;

public class PaymentCardStorage {
    public static Map<String, BankAccountWithPaymentCard> paymentCardMapToAccounts = new HashMap<>();
    public static Map<String, PaymentCard> paymentCardMapToCardNumber = new HashMap<>();

}
