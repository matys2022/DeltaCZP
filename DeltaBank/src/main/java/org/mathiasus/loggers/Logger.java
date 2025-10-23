package org.mathiasus.loggers;

public interface Logger {

    public String getId();

    public LogType getType();

    public String getMessage();
}
