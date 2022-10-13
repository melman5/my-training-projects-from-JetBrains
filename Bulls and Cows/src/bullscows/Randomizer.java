package bullscows;

import java.util.*;

public class Randomizer {

    private static final StringBuilder secretCode = new StringBuilder();
    private  static final LinkedHashSet<Character> randomCode = new LinkedHashSet<>();

    public String getCode(int secretCodeLength, int numberOfPossibleSymbols) {
        createSecreteCode(secretCodeLength, numberOfPossibleSymbols);
        System.out.println(secretCode);
        return secretCode.toString();
    }

    private static void createSecreteCode(int codeLength, int possibleSymbols) {

        while (randomCode.size() != codeLength) {
            String set = "0123456789abcdefghijklmnopqrstuvwxyz";
            randomCode.add(set.charAt((int) (Math.random() * possibleSymbols)));

        }
        for (Character character : randomCode) {
            secretCode.append(character);
        }
    }
}
