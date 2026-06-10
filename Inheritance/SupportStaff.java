package Inheritance;

public class SupportStaff extends Employee {
    boolean uniform;
    int problems;

    public SupportStaff(String name, int id, double salary, boolean uniform, int problems){
        super(name, id, salary);
        this.uniform = uniform;
        this.problems = problems;
    }

    public boolean hasUniform() {
        return uniform;
    }

    public int getProblems() {
        return problems;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Uniform: " + uniform);
        System.out.println("Problems handled: " + problems);
    }
}
