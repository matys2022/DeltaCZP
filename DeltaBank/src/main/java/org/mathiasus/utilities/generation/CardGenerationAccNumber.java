package org.mathiasus.utilities.generation;

import java.util.UUID;

public class CardGenerationAccNumber {
    public CardGenerationAccNumber() {
    }
    public String generateAccNumber(){
        String formatted = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        long parsed1 = Long.parseUnsignedLong(formatted.substring(0, 8), 16);
        long parsed2 = Long.parseUnsignedLong(formatted.substring(9, 16), 16);
        return  (parsed1 + "" + parsed2);
    }
}
