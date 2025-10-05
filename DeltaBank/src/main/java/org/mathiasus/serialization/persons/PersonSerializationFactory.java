package org.mathiasus.serialization.persons;

import org.mathiasus.persons.Person;
import org.mathiasus.persons.customers.Customer;

public class PersonSerializationFactory {
    public PersonSerializationFactory(){

    }
    public CustomerSerialization createCustomer(Person person){
        if(person instanceof Customer){
            return new CustomerSerialization((Customer) person);
        }
        throw new IllegalArgumentException("Person type is not a Customer Person.");
    }
}
