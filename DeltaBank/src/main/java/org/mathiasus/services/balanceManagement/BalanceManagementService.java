package org.mathiasus.services.balanceManagement;

import com.google.inject.Inject;
import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.BankAccountActivityType;
import org.mathiasus.factories.BankAccountTransactionFactory;
import org.mathiasus.factories.BankLogFactory;
import org.mathiasus.loggers.ActivityLogType;
import org.mathiasus.loggers.LogType;
import org.mathiasus.services.logging.BankLogService;

public class BalanceManagementService {
    @Inject
    private BalanceInputRevisionService inputRevisionService;
    @Inject
    private BalanceManagementService balanceManagementService;
    @Inject
    private BankLogService logService;
    @Inject
    private BankLogFactory bankLogFactory;
    @Inject
    private BankAccountTransactionFactory bankAccountTransactionFactory;

    public BalanceManagementService() {
    }


    public void deposit(BankAccount account, double depositedBalance) {

        if(inputRevisionService.ValidateDeposit(account, depositedBalance)) {

            account.setMonthlyDepositedBalance(account.getMonthlyDepositedBalance() + depositedBalance);

            account.setBalance(account.getBalance() + depositedBalance);

            account.addTransaction(
                    bankAccountTransactionFactory.createBankAccountTransaction(BankAccountActivityType.CASH_ACTIVITY_BANK, depositedBalance)
            );

            logService.createLog(bankLogFactory.createBalanceLog(
                    LogType.INFO,
                    ActivityLogType.DEPOSIT,
                    "You have deposited onto your account -> " + depositedBalance,
                    account.getBankAccountNumber()
            ));

        }else {
            throw new RuntimeException("Unable to withdraw");
        }
    }

    public void withdraw(BankAccount account, double withdrawnBalance) {

        if(inputRevisionService.ValidateWithdrawal(account, withdrawnBalance)) {

            account.setMonthlySpentBalance(account.getMonthlySpentBalance() + withdrawnBalance);

            account.setBalance(account.getBalance() -  withdrawnBalance);

            account.addTransaction(
                    bankAccountTransactionFactory.createBankAccountTransaction(BankAccountActivityType.CASH_ACTIVITY_BANK, (-withdrawnBalance))
            );

            logService.createLog(bankLogFactory.createBalanceLog(LogType.INFO, ActivityLogType.WITHDRAW, "You have withdrawn -> " + withdrawnBalance + " from your bank account", account.getBankAccountNumber()));

        }else{
            throw  new RuntimeException("Unable to withdraw");
        }
    }

}
