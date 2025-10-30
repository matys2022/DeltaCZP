package org.mathiasus.facades;

import com.google.inject.Inject;
import org.javatuples.Pair;
import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.services.manageInterest.InterestCalculatorService;
import org.mathiasus.storage.BankAccountStorage;

import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;


public class InterestRunnerFacade {
    @Inject
    InterestCalculatorService interestCalculatorService;

    public InterestRunnerFacade() {

    }

    public HashMap<String, SaveAccount> processAllInterests() {
        List<BankAccount> SavingAccounts = BankAccountStorage.accountNumberToBankAccount.stream().filter(acc -> acc instanceof SaveAccount).toList();
        List<SaveAccount> SavingAccountsCasted = SavingAccounts.stream().map(acc -> (SaveAccount)acc).toList();

        HashMap<String, SaveAccount> pairedValues = new HashMap<>();
        SavingAccountsCasted.forEach(SavingAccount -> {
        double interest = interestCalculatorService.calculate(SavingAccount);

            if (Instant.now().isAfter((SavingAccount.getNextTerm().atZone(ZoneId.of("Europe/Prague")).toInstant()))) {
                SavingAccount.setBalance(SavingAccount.getBalance() + interest);

                SavingAccount.setNextTerm(SavingAccount.getNextTerm()
                        .plusMonths((SavingAccount.isMonthly()?1:12)));

                pairedValues.put(Double.toString(interest), SavingAccount);
            }

        });
        return pairedValues;
    }
}
