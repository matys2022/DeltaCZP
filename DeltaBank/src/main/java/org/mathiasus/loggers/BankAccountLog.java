package org.mathiasus.loggers;

public abstract class BankAccountLog extends BankLog{

    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public BankAccountLog(String id, LogType type, String message, String accountId) {
       super(id, type, message);
       this.accountId = accountId;
    }

}
