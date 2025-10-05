package org.mathiasus.persons;

public abstract class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public Person(){
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
    }
    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

}
