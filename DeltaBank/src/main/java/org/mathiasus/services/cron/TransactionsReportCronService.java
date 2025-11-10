package org.mathiasus.services.cron;

import com.google.inject.Inject;
import org.mathiasus.facades.TransactionPlotterFacade;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TransactionsReportCronService implements ICron{

    @Inject
    TransactionPlotterFacade transactionPlotterFacade;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public TransactionsReportCronService() {
    }

    @Override
    public void run() {
        Runnable interestTask = () -> {
            task();
            System.out.println("Transactions task executed at: " + System.currentTimeMillis());
        };

        scheduler.scheduleAtFixedRate(interestTask, 10, 10, TimeUnit.SECONDS);

        System.out.println("Transaction task scheduled.");
    }

    @Override
    public void shutdown() {

        try {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
                if (!scheduler.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Scheduler did not terminate");
            }
        } catch (InterruptedException ie) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    private void task() {


        //run the Facade
        transactionPlotterFacade.plotAllTransactions(".");

    }
}
