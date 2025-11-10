package org.mathiasus.serialization.transactions;
import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.BankAccountActivityType;
import org.mathiasus.accounts.BankAccountTransaction;
import java.time.LocalDateTime;

public class BankAccountTransactionStringSerializationService{


    public BankAccountTransactionStringSerializationService() {
    }

    public String serialize(BankAccount account, BankAccountTransaction serializable) {

        StringBuilder builder = new StringBuilder();

        builder.append(serializable.getDateTime().toString());
        builder.append(" # Account n. ");
        builder.append(account.getBankAccountNumber());
        builder.append(" | ");
        builder.append(serializable.getActivityType());
        builder.append(" —> ");
        builder.append(serializable.getAmount());




        return builder.toString();
    }

    public BankAccountTransaction deserialize(String serializable) {

        try {
            String[] items = serializable.split("[#.\\|\\->]");
            return new BankAccountTransaction(
                    LocalDateTime.parse(items[0]),
                    BankAccountActivityType.valueOf(items[3]),
                    Double.parseDouble(items[5])
            );
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
