package org.mathiasus.services.cardManagement;

import org.mathiasus.accounts.BankAccountWithPaymentCard;
import org.mathiasus.cards.PaymentCard;
import org.mathiasus.services.balanceManagement.BalanceManagementService;

import static org.mathiasus.storage.PaymentCardStorage.paymentCardMapToAccounts;

public class CardPaymentService {
    private BalanceManagementService balanaceService;

    public CardPaymentService(){
        this.balanaceService = new BalanceManagementService();
    }

    public void deposit(PaymentCard paymentCard, int amount){
        String cardNumber = paymentCard.getCardNumber();

        if(paymentCardMapToAccounts.containsKey(cardNumber)){
            BankAccountWithPaymentCard account = paymentCardMapToAccounts.get(cardNumber);

            balanaceService.deposit(account, amount);
        }else{
            throw new IllegalArgumentException("Invalid card number, card doesn't have any account assigned");
        }


    }
    public void withdraw(PaymentCard paymentCard, int amount){
        String cardNumber = paymentCard.getCardNumber();

        if(paymentCardMapToAccounts.containsKey(cardNumber)){
            BankAccountWithPaymentCard account = paymentCardMapToAccounts.get(cardNumber);
            BalanceManagementService service = new BalanceManagementService();
            balanaceService.withdraw(account, amount);
        }else{
            throw new IllegalArgumentException("Invalid card number, card doesn't have any account assigned");
        }
    }

}
