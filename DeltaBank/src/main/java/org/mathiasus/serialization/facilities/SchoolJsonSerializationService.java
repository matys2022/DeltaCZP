package org.mathiasus.serialization.facilities;

import com.google.gson.Gson;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.serialization.Serialization;


public class SchoolJsonSerializationService implements Serialization {

    private final Gson gson;

    public SchoolJsonSerializationService() {
        this.gson = new Gson();
    }


    @Override
    public String serialize(Object serializable) {
        return gson.toJson(serializable);
    }

    @Override
    public Object deserialize(String serializable) {
        return gson.fromJson(serializable, School.class);
    }
}
