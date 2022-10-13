package tracker;

public class Student {
    private String studentsName;
    private String studentsSurName;
    private String studentsEmail;

    Student(String studentsName, String studentsSurName, String studentsEmail) {
        this.studentsName = studentsName;
        this.studentsSurName = studentsSurName;
        this.studentsEmail = studentsEmail;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public String getStudentsSurName() {
        return studentsSurName;
    }

    public void setStudentsSurName(String studentsSurName) {
        this.studentsSurName = studentsSurName;
    }

    public String getStudentsEmail() {
        return studentsEmail;
    }

    public void setStudentsEmail(String studentsEmail) {
        this.studentsEmail = studentsEmail;
    }
}
