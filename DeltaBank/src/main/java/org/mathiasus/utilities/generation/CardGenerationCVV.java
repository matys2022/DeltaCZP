package org.mathiasus.utilities.generation;

import java.util.Random;

public class CardGenerationCVV
{
    public CardGenerationCVV() {
    }
    public String generateCVV(){
        return new Random().nextInt(999)+"";
    }
}
