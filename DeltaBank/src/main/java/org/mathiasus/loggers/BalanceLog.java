package org.mathiasus.loggers;

public class BalanceLog extends BankAccountLog{

    ActivityLogType activityLogType;

    public BalanceLog(String id, String message, LogType type, ActivityLogType activityLogType, String accountId){
        super(id, type, message, accountId);
        this.activityLogType = activityLogType;
    }

    public ActivityLogType getActivityLogType() {
        return activityLogType;
    }
}
