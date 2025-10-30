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

    private void task(){
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
    }
    TimeUnit.SECONDS.sleep(5);
    public void run() {
        Runnable interestTask = () -> {
            task();
            System.out.println("Interest task executed at: " + System.currentTimeMillis()); // Placeholder
        };

        scheduler.scheduleAtFixedRate(interestTask, 10, 10, TimeUnit.SECONDS);

        System.out.println("Interest task scheduled.");
    }


    public void shutdownScheduler() {
        scheduler.shutdown();
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
}


