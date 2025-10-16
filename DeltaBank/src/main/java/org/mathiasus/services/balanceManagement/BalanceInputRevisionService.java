package org.mathiasus.services.balanceManagement;

import org.mathiasus.accounts.BankAccount;

public class BalanceInputRevisionService {

    private double inputValue;

    public BalanceInputRevisionService() {
    }

    public boolean ValidateDeposit(BankAccount bankAccount, double inputValue) {

        this.inputValue = inputValue;

        if(!checkDepositAmount()){
            throw new RuntimeException("Deposit value must have a positive value");
        }
        if(!checkAMLA()){
            throw new RuntimeException("Deposit amount exceeded the per-deposit limit");
        }
        if(!checkMonthlyDepositAmount(bankAccount)){
            throw new RuntimeException("Deposit amount exceeded the monthly deposit limit");
        }

        // Passed
        return true;
    }

    public boolean ValidateWithdrawal(BankAccount bankAccount, double inputValue){

        this.inputValue = inputValue;

        if(!checkWithdrawalAmount()){
            throw new RuntimeException("Withdrawal value must be positive");
        }
        if(!checkAvailableBalance(bankAccount)){
            throw new RuntimeException("Not sufficient balance");
        }
        if(!checkMonthLimit(bankAccount)){
            throw new RuntimeException("Processed payment reached monthly limit ");
        }
        if(!checkPaymentLimit(bankAccount)){
            throw new RuntimeException("Processed payment limit reached");
        }
        // Passed
        return true;
    }

    private boolean checkWithdrawalAmount(){
        return inputValue > 0;
    }

    private boolean checkAvailableBalance(BankAccount bankAccount){
        return bankAccount.getBalance() - inputValue >= 0;
    }

    private boolean checkMonthLimit(BankAccount bankAccount){
        // If limit is negative, it behaves the same way, as if no limit ever existed
        if(bankAccount.getMonthlyLimit()>=0)
            return bankAccount.getMonthlyLimit() - inputValue >= 0;
        else return true;
    }

    private boolean checkPaymentLimit(BankAccount bankAccount){
        // If limit is negative, it behaves the same way, as if no limit ever existed
        if(bankAccount.getPerPaymentLimit()>=0)
            return bankAccount.getPerPaymentLimit() - inputValue >= 0;
        else  return true;
    }








    private boolean checkMonthlyDepositAmount(BankAccount bankAccount){
        return checkAMLA(inputValue + bankAccount.getMonthlyDepositedBalance());
    }

    private boolean checkAMLA(double savings){
        return  savings < 10000 * 24.25f;
    }

    private boolean checkAMLA(){
        return  inputValue < 10000 * 24.25f;
    }

    private boolean checkDepositAmount(){
        return inputValue > 0;
    }

}
