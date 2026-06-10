package Inheritance;

public class App {
    public static void main(String[] args){
        Employee emp1 = new Employee("Alice", 101, 50000);
        Teacher teacher1 = new Teacher("Bob", 102, 60000, "Mathematics");

        System.out.println("Employee Information:");
        emp1.displayInfo();
        System.out.println("\nTeacher Information:");
        teacher1.displayInfo();

        emp1.takeLeave();
        teacher1.takeLeave();
        teacher1.markAttendance();
    }
}
