package org.mathiasus.cards;

import org.mathiasus.persons.customers.Customer;



public class DebitCard extends PaymentCard {

    private final double outOfNetworkATMWithdrawalFee;
    public DebitCard() {
        this.outOfNetworkATMWithdrawalFee = 0;
    }
    public DebitCard(String uuid, Customer customer, String cardNumber, String cvv, String expirationMonth, String expirationYear, double fee) {
        super(uuid, customer, cardNumber, cvv, expirationMonth, expirationYear);
        this.outOfNetworkATMWithdrawalFee = fee;
    }
}
