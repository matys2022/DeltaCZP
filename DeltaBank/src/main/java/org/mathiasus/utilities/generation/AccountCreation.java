package org.mathiasus.utilities.generation;

import java.util.UUID;

public class AccountCreation {

    private static int iterations = 0;
    private static Long previousValue = null;
    public AccountCreation(){
    }

    public String CreateAccountNumber(){
        iterations++;

        Number value = (System.currentTimeMillis() + (previousValue != null ? previousValue : 0));
        previousValue = value.longValue();
        return  value.toString().substring(0, 10);
    }

    public String CreateBankAccountUUID(){
        return UUID.randomUUID().toString();
    }


}
