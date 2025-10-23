package org.mathiasus.factories;

import com.google.inject.Inject;
import org.mathiasus.cards.CreditCard;
import org.mathiasus.cards.DebitCard;
import org.mathiasus.cards.PaymentCard;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.utilities.generation.*;

import java.time.LocalDate;
import java.util.Date;

public class PaymentCardFactory {

    @Inject
    private CardGenerationAccNumber cardGenerationAccNumber;
    @Inject
    private CardGenerationCVV cardGenerationCVV;

    @Inject
    private CardGenerationExpDate cardGenerationExpDate;
    @Inject
    private CardGenerationCrdPin cardGenerationCrdPin;
    @Inject
    private CardGenerationUUID cardGenerationUUID;


    public PaymentCardFactory() {}

    public PaymentCard createCreditPaymentCard(Customer customer, double lineOfCreditLimit, double interestRate, Date minimumPaymentDue){
        LocalDate date =  cardGenerationExpDate.generateExpDate();
        String expirationMonth = String.format("%02d", date.getMonthValue());
        String expirationYear =   String.format("%02d",date.getYear()%100);
        return new CreditCard(cardGenerationUUID.generateUUID(), customer, cardGenerationAccNumber.generateAccNumber(), cardGenerationCVV.generateCVV(), expirationMonth, expirationYear, lineOfCreditLimit, interestRate, minimumPaymentDue, cardGenerationCrdPin.generateCrdPin());
    }
    public PaymentCard createDebitPaymentCard(Customer customer, double fee){
        LocalDate date =  cardGenerationExpDate.generateExpDate();
        String expirationMonth = String.format("%02d", date.getMonthValue());
        String expirationYear =   String.format("%02d", date.getYear()%100);
        return new DebitCard(cardGenerationUUID.generateUUID(), customer, cardGenerationAccNumber.generateAccNumber(), cardGenerationCVV.generateCVV(), expirationMonth, expirationYear, fee, cardGenerationCrdPin.generateCrdPin());
    }
}
