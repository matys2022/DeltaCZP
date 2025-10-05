package org.mathiasus.serialization.accounts;

import org.mathiasus.accounts.BankAccount;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.persons.customers.Customer;

public class RegularAccountSerialization extends BankAccountSerialization{



    public RegularAccountSerialization(RegularAccount RegularAccount) {
        super(RegularAccount);
    }


}
