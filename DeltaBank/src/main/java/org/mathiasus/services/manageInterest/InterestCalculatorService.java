package org.mathiasus.services.manageInterest;

import org.mathiasus.accounts.SaveAccount;

public class InterestCalculator {
    public InterestCalculator() {

    }

    public double calculate(SaveAccount saveAccount){
        double interest = saveAccount.getBalance() * saveAccount.getInterestRate();
        if(saveAccount.isMonthly()){
            interest = interest/12;
        }
        return interest;
    }
}
