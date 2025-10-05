package org.mathiasus.serialization.persons;

import org.mathiasus.persons.Person;

public abstract class PersonSerialization {
    public String firstName;
    public String middleName;
    public String lastName;

    public PersonSerialization(Person person) {
        this.firstName = person.getFirstName();
        this.middleName = person.getMiddleName();
        this.lastName = person.getLastName();
    }
}
