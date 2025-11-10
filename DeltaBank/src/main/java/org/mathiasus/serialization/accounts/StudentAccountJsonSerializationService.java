package org.mathiasus.serialization.accounts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import org.mathiasus.accounts.StudentAccount;
import org.mathiasus.adapters.LocalDateTimeAdapter;
import org.mathiasus.serialization.Serialization;

import java.time.LocalDateTime;

public class StudentAccountJsonSerializationService implements Serialization {

    private final Gson gson;

    public StudentAccountJsonSerializationService() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
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
