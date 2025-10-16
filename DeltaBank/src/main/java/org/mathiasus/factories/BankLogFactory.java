package org.mathiasus.factories;

import org.mathiasus.loggers.ActivityLogType;
import org.mathiasus.loggers.BalanceLog;
import org.mathiasus.loggers.LogType;

public class BankLogFactory {
    private int id;
    public BankLogFactory(){
        id = 0;
    }

    public BalanceLog createBalanceLog( LogType type, ActivityLogType activity, String message, String accountId) {
        return new BalanceLog(Integer.toString(id++), message, type, activity, accountId);
    }
    
}
