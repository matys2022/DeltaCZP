package org.mathiasus.serialization.accounts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.adapters.LocalDateTimeAdapter;
import org.mathiasus.serialization.Serialization;

import java.time.LocalDateTime;

public class RegularAccountJsonSerializationService implements Serialization {

    private final Gson gson;

    public RegularAccountJsonSerializationService() {
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
        return gson.fromJson(serializable, RegularAccount.class);
    }
}
