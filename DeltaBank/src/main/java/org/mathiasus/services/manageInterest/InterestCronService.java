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

    public void run() {

        while (true) {
            task();
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Interest task scheduled.");
        }


    }

}


