package org.mathiasus.services.logging;

import org.mathiasus.loggers.ActivityLogType;
import org.mathiasus.loggers.BalanceLog;
import org.mathiasus.loggers.BankLog;
import org.mathiasus.loggers.LogType;
import org.mathiasus.storage.BankLogStorage;

import java.io.Console;

public class BankLogService {
    public BankLogService(){

    }
    // * Balance has been removed
    // * Balance has been added
    // # Not sufficient balance
    // # Input value has exceeded the allowed maximum
    // && Account has been taken over
    // && Payment card expired
    public String createLog(BankLog bankLog) {
        StringBuilder builder = new StringBuilder();

        if (bankLog instanceof BalanceLog) {
            if (bankLog.getType() == LogType.ERROR) {
                builder.append(" && ");
            }
            if (bankLog.getType() == LogType.WARNING) {
                builder.append(" # ");
            }
            if (bankLog.getType() == LogType.INFO) {
                builder.append(" * ");
            }

            builder.append("(");
            builder.append(((BalanceLog) bankLog).getAccountId());
            builder.append(")");

            if (((BalanceLog) bankLog).getActivityLogType() == ActivityLogType.CARD) {
                builder.append(" | PAYMENT CARD | ");
            }
            if (((BalanceLog) bankLog).getActivityLogType() == ActivityLogType.DEPOSIT) {
                builder.append(" | DEPOSIT | ");
            }
            if (((BalanceLog) bankLog).getActivityLogType() == ActivityLogType.WITHDRAW) {
                builder.append(" | WITHDRAW | ");
            }
            if (((BalanceLog) bankLog).getActivityLogType() == ActivityLogType.TRANSFER) {
                builder.append(" | TRANSFER | ");
            }

            builder.append("–> ");
            builder.append(bankLog.getMessage());

        }

        String entry = builder.toString();

        BankLogStorage.BankLogs.add(entry);
        System.out.println(entry);

        return entry;
    }
//    public String getLog(){
//
//    }
}
