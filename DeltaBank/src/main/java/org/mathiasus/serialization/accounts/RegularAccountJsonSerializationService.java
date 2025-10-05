package org.mathiasus.serialization.accounts;

import com.google.gson.Gson;
import org.mathiasus.accounts.RegularAccount;
import org.mathiasus.serialization.Serialization;

public class RegularAccountJsonSerializationService implements Serialization {

    private final Gson gson;

    public RegularAccountJsonSerializationService() {
        this.gson = new Gson();
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
