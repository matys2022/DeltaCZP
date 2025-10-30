package org.mathiasus.services.manageInterest;

import com.google.inject.Inject;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.facades.InterestRunnerFacade;
import org.mathiasus.factories.BankLogFactory;
import org.mathiasus.loggers.ActivityLogType;
import org.mathiasus.loggers.LogType;
import org.mathiasus.services.logging.BankLogService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class InterestCronService {

    @Inject
    InterestRunnerFacade interestRunnerFacade;

    @Inject
    BankLogService bankLogService;

    @Inject
    BankLogFactory bankLogFactory;

    public InterestCronService() {
    }

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void run() {
        // The Runnable task, which contains the logic from your run() method
        Runnable interestTask = () -> {
            HashMap<String, SaveAccount> affectedAccounts = interestRunnerFacade.processAllInterests();
            affectedAccounts.forEach((interest,saveAccount)->
                    {
                        bankLogService.createLog(bankLogFactory.createBalanceLog(
                                LogType.INFO,
                                ActivityLogType.INTEREST,
                                "Interest update with amount of" + interest,
                                saveAccount.getBankAccountNumber()
                        ));
                    }
            );
            System.out.println("Interest task executed at: " + System.currentTimeMillis()); // Placeholder
        };

        scheduler.scheduleAtFixedRate(interestTask, 10, 10, TimeUnit.SECONDS);

        System.out.println("Interest task scheduled.");
    }

    // You should shut down the scheduler when your application is closing gracefully
    public void shutdownScheduler() {
        scheduler.shutdown();
        try {
            // Wait for existing tasks to terminate
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow(); // Cancel currently executing tasks
                if (!scheduler.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Scheduler did not terminate");
            }
        } catch (InterruptedException ie) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // Example usage (in a main method or application startup)

}


