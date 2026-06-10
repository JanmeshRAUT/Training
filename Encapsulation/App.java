package Encapsulation;

public class App {
    public static void main(String[] args) {
        MITEmp Teacher = new MITEmp("John Doe", 101, 50000.0);

        
        System.out.println(Teacher.displaySalary());
    }
}
