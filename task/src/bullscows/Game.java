package bullscows;

import java.util.Scanner;

public class Game {
    private static final Randomizer secretCodeRandomizer = new Randomizer();
    private final static Scanner scanner = new Scanner(System.in);
    private static int secretCodeLength;
    private static boolean action = true;
    private static int numberOfPossibleSymbols;
    private static int turn = 1;

    public static void game() {
        String checkCodeLength = null;
        String checkPossibleSymbols = null;
        try {
            System.out.println("Input the length of the secret code:");
            checkCodeLength = scanner.nextLine();
            secretCodeLength = Integer.parseInt(checkCodeLength);
        } catch (Exception e) {
            System.out.printf("Error: '%s' isn't a valid number.", checkCodeLength);
            System.exit(1);
        }

        try {
            System.out.println("Input the number of possible symbols in the code:");
            checkPossibleSymbols = scanner.nextLine();
            numberOfPossibleSymbols = Integer.parseInt(checkPossibleSymbols);
        } catch (Exception e) {
            System.out.printf("Error: '%s' isn't a valid number.", checkPossibleSymbols);
            System.exit(1);
        }

        if (numberOfPossibleSymbols < secretCodeLength) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", secretCodeLength, numberOfPossibleSymbols);
            System.exit(1);
        } else if (numberOfPossibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(1);
        } else if (secretCodeLength == 0) {
            System.out.println("error");
            System.exit(1);
        }
        startGame();
        String code = String.valueOf(secretCodeRandomizer.getCode(secretCodeLength, numberOfPossibleSymbols));

        while (action) {
            System.out.printf("Turn %d:\n", turn);
            turn++;
            answer(code);
        }
    }
    private static void startGame() {

        StringBuilder stars = new StringBuilder();
        stars.append("*".repeat(Math.max(0, secretCodeLength)));

            if (numberOfPossibleSymbols < 10) {
                System.out.printf("The secret is prepared: %s %s\n", stars, "(0-9)");
            } else if (numberOfPossibleSymbols == 10) {
                System.out.printf("The secret is prepared: %s (0-9, a)\n", stars);
            } else {
                System.out.printf("The secret is prepared: %s (0-9, a-%c)\n", stars, (numberOfPossibleSymbols - 11 + 97));
            }
            System.out.println("Okay, let's start a game!");
        }

    private static void answer(String code) {
        String answer = scanner.next();
        Finder.checker(code, answer);
        if (code.equals(answer)) {
            System.out.println("Congratulations! You guessed the secret code.");
            action = false;
        }
    }
}
