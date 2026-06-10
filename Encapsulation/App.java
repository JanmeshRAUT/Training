package Encapsulation;

public class App {
    public static void main(String[] args) {
        MITEmp Teacher = new MITEmp("John Doe", 101, 50000.0);

        MITEmp Student = new MITEmp("Jane Smith", 102, 0.0);
        Student.setSalary(45000.0);
        System.out.println(Teacher.displaySalary());
        System.out.println(Student.getSalary());
    }
}
