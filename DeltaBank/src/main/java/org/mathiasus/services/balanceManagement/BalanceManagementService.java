package org.mathiasus.services.balanceManagement;

import org.mathiasus.accounts.BankAccount;

public class BalanceManagementService {


//    private final BankAccount account;
    private final BalanceInputRevisionService inputRevisionService;

    public BalanceManagementService() {
//        this.account = account;
        this.inputRevisionService = new BalanceInputRevisionService();
    }


    public void deposit(BankAccount account, double depositedBalance) {

        if(inputRevisionService.ValidateDeposit(account, depositedBalance)) {

            account.setMonthlyDepositedBalance(account.getMonthlyDepositedBalance() + depositedBalance);

            account.setBalance(account.getBalance() + depositedBalance);

        }else {
            throw new RuntimeException("Unable to withdraw");
        }
    }

    public void withdraw(BankAccount account, double withdrawnBalance) {

        if(inputRevisionService.ValidateWithdrawal(account, withdrawnBalance)) {

            account.setMonthlySpentBalance(account.getMonthlySpentBalance() + withdrawnBalance);

            account.setBalance(account.getBalance() -  withdrawnBalance);

        }else{
            throw  new RuntimeException("Unable to withdraw");
        }
    }

//    public BankAccount getAccount() {
//        return account;
//    }
}
