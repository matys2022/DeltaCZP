package org.mathiasus.services.manageInterest;

import org.mathiasus.accounts.SaveAccount;

public class InterestCalculatorService {
    public InterestCalculatorService() {

    }

    public double calculate(SaveAccount saveAccount){
        double interest = saveAccount.getBalance() * (-saveAccount.getInterestRate());
        if(saveAccount.isMonthly()){
            interest = interest/12;
        }
        return interest;
    }
}
