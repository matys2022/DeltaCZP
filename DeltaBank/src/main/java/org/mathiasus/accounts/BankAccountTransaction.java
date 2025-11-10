package org.mathiasus.accounts;

import java.time.LocalDateTime;

public class BankAccountTransaction {
    LocalDateTime dateTime;
    BankAccountActivityType activityType;
    Double amount;
    boolean exported;

    public BankAccountTransaction(BankAccountActivityType activityType, Double amount){
        this.dateTime = LocalDateTime.now();
        this.exported = false;

        this.activityType = activityType;
        this.amount = amount;
    }

    public BankAccountTransaction(LocalDateTime dateTime, BankAccountActivityType activityType, Double amount) {

    }

    public boolean isExported() {
        return exported;
    }

    public void setExported(boolean exported) {
        this.exported = exported;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public BankAccountActivityType getActivityType() {
        return activityType;
    }

    public Double getAmount() {
        return amount;
    }
}
