package Abstract;

abstract public class Employee {
    String id;
    String name;
    double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateAnnualSalary();
}