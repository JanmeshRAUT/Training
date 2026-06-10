package Inheritance;

public class Teacher extends Employee {
    private String subject;

    public Teacher(String name, int id, double salary, String subject) {
        super(name, id, salary);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
    void markAttendance() {
        System.out.println(getName() + " is marking attendance.");
    }
}
