package org.mathiasus.services.balanceManagement;

import org.mathiasus.accounts.BankAccount;

public class BalanceInputRevisionService {

    private final BankAccount bankAccount;
    private double inputValue;

    public BalanceInputRevisionService(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean ValidateDeposit(double inputValue) {

        this.inputValue = inputValue;

        if(!checkDepositAmount()){
            throw new RuntimeException("Deposit value must have a positive value");
        }
        if(!checkAMLA()){
            throw new RuntimeException("Deposit amount exceeded the per-deposit limit");
        }
        if(!checkMonthlyDepositAmount()){
            throw new RuntimeException("Deposit amount exceeded the monthly deposit limit");
        }

        // Passed
        return true;
    }

    public boolean ValidateWithdrawal(double inputValue){

        this.inputValue = inputValue;

        if(!checkWithdrawalAmount()){
            throw new RuntimeException("Withdrawal value must be positive");
        }
        if(!checkAvailableBalance()){
            throw new RuntimeException("Not sufficient balance");
        }
        if(!checkMonthLimit()){
            throw new RuntimeException("Processed payment reached monthly limit ");
        }
        if(!checkPaymentLimit()){
            throw new RuntimeException("Processed payment limit reached");
        }
        // Passed
        return true;
    }

    private boolean checkWithdrawalAmount(){
        return inputValue > 0;
    }

    private boolean checkAvailableBalance(){
        return bankAccount.getBalance() - inputValue >= 0;
    }

    private boolean checkMonthLimit(){
        // If limit is negative, it behaves the same way, as if no limit ever existed
        if(bankAccount.getMonthlyLimit()>=0)
            return bankAccount.getMonthlyLimit() - inputValue >= 0;
        else return true;
    }

    private boolean checkPaymentLimit(){
        // If limit is negative, it behaves the same way, as if no limit ever existed
        if(bankAccount.getPerPaymentLimit()>=0)
            return bankAccount.getPerPaymentLimit() - inputValue >= 0;
        else  return true;
    }








    private boolean checkMonthlyDepositAmount(){
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
