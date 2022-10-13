package bullscows;

public class Finder {
    public static void checker(String code, String answer) {
        int bulls = 0;
        int cows = 0;

        for(int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == code.charAt(i)) {
                bulls += 1;
            } else if (answer.contains(String.valueOf(code.charAt(i)))) {
                cows += 1;
            }
        }

        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None");
        } else if (bulls == 0) {
            System.out.printf("Grade: %d cow(s)\n", cows);
        } else if (cows == 0) {
            System.out.printf("Grade: %d bull(s)\n", bulls);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n", bulls, cows);
        }

    }
}
