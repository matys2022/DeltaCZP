package org.mathiasus.facades;

import com.google.inject.Inject;
import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.BankAccountTransaction;
import org.mathiasus.serialization.transactions.BankAccountTransactionStringSerializationService;
import org.mathiasus.storage.BankAccountStorage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class TransactionPlotterFacade {

    @Inject
    BankAccountTransactionStringSerializationService bankAccountTransactionStringSerializationService;

    public TransactionPlotterFacade() {
    }


    public void plotAllTransactions(String destination) {

        HashMap<BankAccount, BankAccountTransaction> newTransactions = new HashMap();

        BankAccountStorage.accountNumberToBankAccount.stream().forEach(account -> {
            account.getTransactions().stream().forEach(transaction -> {
                if(!transaction.isExported()){
                    newTransactions.put(account,transaction);
                    transaction.setExported(true);
                }
            });
        });

        //Serialize transactions
        StringBuilder transactions = new StringBuilder();

        newTransactions.forEach((account, transaction) -> {
            transactions.append(bankAccountTransactionStringSerializationService.serialize(account, transaction));
        });


        // Write serialized transactions into the file
        try{
            // Try to reach the destination file
            FileWriter fileWriter = new FileWriter(destination + "/log.txt");
            BufferedWriter printWriter = new BufferedWriter(fileWriter);

            //Write the string
            printWriter.write(transactions.toString());
            printWriter.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}
