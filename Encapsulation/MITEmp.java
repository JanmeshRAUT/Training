package Encapsulation;

public class MITEmp {
    String name;
    int id;
    private double salary;

    MITEmp(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    
    public double displaySalary() {
        return salary;
    }
}
