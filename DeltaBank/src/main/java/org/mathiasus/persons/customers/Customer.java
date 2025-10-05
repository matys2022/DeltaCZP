package org.mathiasus.persons.customers;

import org.mathiasus.persons.Person;

public class Customer extends Person {
    private final String uuid;

    public Customer(){
        this.uuid = null;
    }

    public Customer(String uuid, String firstName, String middleName, String lastName) {
        super(firstName, middleName, lastName);
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }

}
