package org.mathiasus.serialization.accounts;

import com.google.gson.Gson;
import org.mathiasus.accounts.StudentAccount;
import org.mathiasus.serialization.Serialization;

public class StudentAccountJsonSerializationService implements Serialization {

    private final Gson gson;

    public StudentAccountJsonSerializationService() {
        this.gson = new Gson();
    }

    @Override
    public String serialize(Object serializable) {
        return gson.toJson(serializable);
    }

    @Override
    public Object deserialize(String serializable) {
        return gson.fromJson(serializable, StudentAccount.class);
    }
}
