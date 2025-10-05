package org.mathiasus.serialization;

import java.io.Serializable;

public interface Serialization {
    public String serialize(Object serializable);
    public Object deserialize(String serializable);
}
