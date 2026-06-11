package Abstract;

public class Hr extends Employee {
    double allowance;

    public Hr(double allowance, String id, String name, double salary) {
        super(id, name, salary);
        this.allowance = allowance;
    }
    
    @Override
    double calculateAnnualSalary() {
        return (salary * 12) + allowance;
    }
}
