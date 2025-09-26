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

        if(reviseDepositAmount()){
            if(checkAMLA()){
                if(reviseMonthlyDepositAmount()){
                    // Passed
                    return true;
                }else{
                    throw new RuntimeException("Deposit amount exceeded the monthly deposit limit");
                }
            }else{
                throw new RuntimeException("Deposit amount exceeded the per-deposit limit");
            }
        }else{
            throw new RuntimeException("Deposit value must have a positive value");
        }
    }

    public boolean ValidateWithdrawal(double inputValue){

        this.inputValue = inputValue;

        if(reviseWithdrawalAmount()){
            if(reviseAvailableBalance()){
                if(reviseMonthLimit()){
                    if(revisePaymentLimit()){
                        // Passed
                        return true;
                    } else{
                        throw new RuntimeException("Processed payment limit reached");
                    }
                }else {
                    throw new RuntimeException("Processed payment reached monthly limit ");
                }
            }else  {
                throw new RuntimeException("Not sufficient balance");
            }
        }else{
            throw new RuntimeException("Withdrawal value must be positive");
        }
    }

    private boolean reviseWithdrawalAmount(){
        return inputValue > 0;
    }

    private boolean reviseAvailableBalance(){
        return bankAccount.getBalance() - inputValue >= 0;
    }

    private boolean reviseMonthLimit(){
        // If limit is negative, it behaves like no limit exists
        if(bankAccount.getMonthlyLimit()>=0)
            return bankAccount.getMonthlyLimit() - inputValue >= 0;
        else return true;
    }

    private boolean revisePaymentLimit(){
        // If limit is negative, it behaves like no limit exists
        if(bankAccount.getPerPaymentLimit()>=0)
            return bankAccount.getPerPaymentLimit() - inputValue >= 0;
        else  return true;
    }








    private boolean reviseMonthlyDepositAmount(){
        return checkAMLA(inputValue + bankAccount.getMonthlyDepositedBalance());
    }

    private boolean checkAMLA(double savings){
        return  savings < 10000 * 24.25f;
    }

    private boolean checkAMLA(){
        return  inputValue < 10000 * 24.25f;
    }

    private boolean reviseDepositAmount(){
        return inputValue > 0;
    }

}
