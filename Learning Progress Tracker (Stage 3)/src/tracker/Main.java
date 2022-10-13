package tracker;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");
        input();
    }
    private static void input() {
        String inputData;
        do {
            inputData = scanner.nextLine();
            if (inputData.isBlank()) {
                System.out.println("No input.");
            } else {
                switch (inputData) {
                    case "add students": {
                        Menu.addNewStudent();
                        break;
                    } case "exit": {
                        System.out.println("Bye!");
                        break;
                    } case "back": {
                        System.out.println("Enter 'exit' to exit the program.");
                        break;
                    }
                    default: {
                        System.out.println("Error: unknown command!");
                        break;
                    }
                }
            }
        }while (!inputData.equals("exit")) ;
    }
}
