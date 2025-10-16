package org.mathiasus.utilities.generation;

import java.util.Random;
import java.util.UUID;

public class CardGeneration {
    public CardGeneration() {}


    public String generateAccountNumber(){
        String formatted = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        long parsed1 = Long.parseUnsignedLong(formatted.substring(0, 8), 16);
        long parsed2 = Long.parseUnsignedLong(formatted.substring(9, 16), 16);
        return  (parsed1 + "" + parsed2);
    }

    public String generateUUID(){return UUID.randomUUID().toString();}

    public String generateCardCVV(){
        return new Random().nextInt(999)+"";
    }

}
