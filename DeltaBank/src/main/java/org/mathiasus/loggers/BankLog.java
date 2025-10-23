package org.mathiasus.loggers;

public abstract class BankLog implements Logger {
    private String id;
    private LogType type;
    private String message;

    public String getId() {
        return id;
    }

    public LogType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public BankLog(String id, LogType type, String message){
        this.id = id;
        this.type = type;
        this.message = message;
    }
    public BankLog(){
    }

}
