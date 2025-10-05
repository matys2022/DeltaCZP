package org.mathiasus.serialization.accounts;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.accounts.StudentAccount;

public class BankAccountSerializationFactory {

    public  BankAccountSerializationFactory(){

    }

    public RegularAccountSerialization createRegularAccountSerialization(BankAccount bankAccount){
        if(bankAccount instanceof RegularAccount) {
            return new RegularAccountSerialization((RegularAccount)bankAccount);
        }
        throw new IllegalArgumentException("Bank account type is not a regular account");
    }

    public SaveAccountSerialization createSaveAccountSerialization(BankAccount bankAccount){
        if(bankAccount instanceof SaveAccount) {
            return  new SaveAccountSerialization((SaveAccount)bankAccount);
        }
        throw new IllegalArgumentException("Bank account type is not a save account");
    }

    public StudentAccountSerialization createStudentAccountSerialization(BankAccount bankAccount){
        if(bankAccount instanceof StudentAccount) {
            return new StudentAccountSerialization((StudentAccount)bankAccount);
        }
        throw new IllegalArgumentException("Bank account type is not a student account");
    }

}
