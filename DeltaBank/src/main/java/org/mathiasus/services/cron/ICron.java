package org.mathiasus.services.cron;

public interface ICron {
    public void run();
    public void shutdown();
    private void task(){};
}
