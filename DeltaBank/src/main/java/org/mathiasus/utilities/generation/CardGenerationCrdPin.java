package org.mathiasus.utilities.generation;

import java.util.Random;

public class CardGenerationCrdPin {
    public CardGenerationCrdPin() {
    }
    public String generateCrdPin(){
        return String.format("%04d", new Random().nextInt(9999));
    }
}

