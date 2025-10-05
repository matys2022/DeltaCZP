package org.mathiasus.serialization.accounts;

import org.mathiasus.accounts.StudentAccount;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.serialization.facilities.SchoolSerialization;

public class StudentAccountSerialization extends  BankAccountSerialization{

    public SchoolSerialization school;

    public StudentAccountSerialization(StudentAccount studentAccount) {
        super(studentAccount);

        this.school = new SchoolSerialization(studentAccount.getSchool());
    }

}
