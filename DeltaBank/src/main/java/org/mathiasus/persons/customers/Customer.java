package org.mathiasus.persons.customers;

public class Customer {
    private final String uuid;
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Customer(String uuid, String firstName, String middleName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
