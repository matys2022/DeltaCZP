package org.mathiasus.serialization.persons;

import org.mathiasus.persons.customers.Customer;

public class CustomerSerialization extends PersonSerialization {
    public String uuid;

    public CustomerSerialization(Customer customer) {
        super(customer);
        this.uuid = customer.getUuid();

    }
}
