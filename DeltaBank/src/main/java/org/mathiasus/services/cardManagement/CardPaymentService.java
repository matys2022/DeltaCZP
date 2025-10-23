package org.mathiasus.services.cardManagement;

import com.google.inject.Inject;
import org.mathiasus.accounts.BankAccountWithPaymentCard;
import org.mathiasus.cards.PaymentCard;
import org.mathiasus.factories.BankLogFactory;
import org.mathiasus.loggers.ActivityLogType;
import org.mathiasus.loggers.LogType;
import org.mathiasus.services.balanceManagement.BalanceManagementService;
import org.mathiasus.services.logging.BankLogService;

import static org.mathiasus.storage.PaymentCardStorage.paymentCardMapToAccounts;

public class CardPaymentService {


    @Inject
    private BalanceManagementService balanceManagementService;

    @Inject
    private BankLogService logService;

    @Inject
    private BankLogFactory bankLogFactory;


    public CardPaymentService(){}

    public void deposit(PaymentCard paymentCard, int amount){
        String cardNumber = paymentCard.getCardNumber();

        if(paymentCardMapToAccounts.containsKey(cardNumber)){
            BankAccountWithPaymentCard account = paymentCardMapToAccounts.get(cardNumber);

            balanceManagementService.deposit(account, amount);
        }else{
            throw new IllegalArgumentException("Invalid card number, card doesn't have any account assigned");
        }


    }
    public void withdraw(PaymentCard paymentCard, int amount){
        String cardNumber = paymentCard.getCardNumber();

        if(paymentCardMapToAccounts.containsKey(cardNumber)){
            BankAccountWithPaymentCard account = paymentCardMapToAccounts.get(cardNumber);
            balanceManagementService.withdraw(account, amount);
            logService.createLog(this.bankLogFactory.createBalanceLog(LogType.INFO, ActivityLogType.CARD, "You have paid with a payment card -> " + amount, account.getBankAccountNumber()));
        }else{
            throw new IllegalArgumentException("Invalid card number, card doesn't have any account assigned");
        }
    }

}
