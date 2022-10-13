package tracker;

import java.util.Objects;

import static tracker.Main.scanner;

public class Menu {

    private static int studentsTotal = 0;

    public static void addNewStudent() {
        System.out.println("Enter student credentials or 'back' to return.");
        String studentInfo = "";
        while (!Objects.equals(studentInfo, "back")) {
            studentInfo = scanner.nextLine();
            if (Objects.equals(studentInfo, "exit")) {
                System.out.println("Incorrect credentials.");
            } else if (!Objects.equals(studentInfo, "back")) {
                System.out.println(checkStudent(studentInfo));
            }
        }
        System.out.printf("Total %d students have been added.\n", studentsTotal);
    }

    private static String checkStudent(String studentInfo) {
        String[] subFirstName = (studentInfo.split(" "));

        boolean checkStudentsName = studentInfo.matches("(([A-Z])([a-z]+)(.*))|(([a-zA-Z])('|\\S)?([a-zA-Z]+)('|\\S|\\s)?([a-zA-Z])([a-z]+)\\s(.*))");
        boolean checkStudentsSurName = studentInfo.matches("(.*)\\s([a-zA-Z])('|\\S)?([a-zA-Z])?([a-z]+)\\s(.*)");
        boolean checkStudentsEmail = studentInfo.matches("(.*)\\s(([a-zA-Z\\d]+)\\.?([a-zA-Z\\d]+)?@([a-zA-Z\\d]+)\\.([a-zA-Z\\d]+))");

        if (subFirstName.length <= 2) {
            return "Incorrect credentials.";
        } else if (!checkStudentsName && !checkStudentsSurName && !checkStudentsEmail) {
            return "Incorrect credentials.";
        } else if (!checkStudentsName) {
            return "Incorrect first name.";
        } else if (!checkStudentsSurName) {
            return "Incorrect last name.";
        } else if (!checkStudentsEmail) {
            return "Incorrect email.";
        } else {
            studentsTotal++;
            return "The student has been added.";
        }
    }
}
