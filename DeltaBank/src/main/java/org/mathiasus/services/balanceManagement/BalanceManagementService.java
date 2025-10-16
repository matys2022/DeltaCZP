package org.mathiasus.services.balanceManagement;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.factories.BankLogFactory;
import org.mathiasus.loggers.ActivityLogType;
import org.mathiasus.loggers.LogType;
import org.mathiasus.services.logging.BankLogService;

public class BalanceManagementService {


//    private final BankAccount account;
    private final BalanceInputRevisionService inputRevisionService;
    private BalanceManagementService balanaceService;
    private BankLogService logService;
    private BankLogFactory bankLogFactory;

    public BalanceManagementService() {
//        this.account = account;
        this.inputRevisionService = new BalanceInputRevisionService();
        this.logService = new BankLogService();
        this.bankLogFactory = new BankLogFactory();
    }


    public void deposit(BankAccount account, double depositedBalance) {

        if(inputRevisionService.ValidateDeposit(account, depositedBalance)) {

            account.setMonthlyDepositedBalance(account.getMonthlyDepositedBalance() + depositedBalance);

            account.setBalance(account.getBalance() + depositedBalance);

            logService.createLog(bankLogFactory.createBalanceLog(LogType.INFO, ActivityLogType.DEPOSIT, "You have deposited onto your account -> " + depositedBalance, account.getBankAccountNumber()));

        }else {
            throw new RuntimeException("Unable to withdraw");
        }
    }

    public void withdraw(BankAccount account, double withdrawnBalance) {

        if(inputRevisionService.ValidateWithdrawal(account, withdrawnBalance)) {

            account.setMonthlySpentBalance(account.getMonthlySpentBalance() + withdrawnBalance);

            account.setBalance(account.getBalance() -  withdrawnBalance);

            logService.createLog(bankLogFactory.createBalanceLog(LogType.INFO, ActivityLogType.WITHDRAW, "You have withdrawn -> " + withdrawnBalance + " from your bank account", account.getBankAccountNumber()));

        }else{
            throw  new RuntimeException("Unable to withdraw");
        }
    }

//    public BankAccount getAccount() {
//        return account;
//    }
}
