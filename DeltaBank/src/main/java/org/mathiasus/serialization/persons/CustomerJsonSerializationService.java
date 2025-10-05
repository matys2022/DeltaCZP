package org.mathiasus.serialization.persons;

import com.google.gson.Gson;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.serialization.Serialization;

public class CustomerJsonSerializationService implements Serialization {
    private final Gson gson;

    public CustomerJsonSerializationService() {
        this.gson = new Gson();
    }


    @Override
    public String serialize(Object serializable) {
        return gson.toJson(serializable);
    }

    @Override
    public Object deserialize(String serializable) {
        return gson.fromJson(serializable, Customer.class);
    }
}
