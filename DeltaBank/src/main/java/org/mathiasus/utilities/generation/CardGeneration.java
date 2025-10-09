package org.mathiasus.utilities.generation;

import java.util.Random;
import java.util.UUID;

public class CardGeneration {
    public CardGeneration() {

    }
    public String generateAccountNumber(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    public String generateUUID(){
        return UUID.randomUUID().toString();
    }
    public String generateCardCVV(){
        return new Random().nextInt(999)+"";
    }

}
