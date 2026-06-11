package Abstract;

public class Developer extends Employee {
    double bonus;

    public Developer(double bonus, String id, String name, double salary) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    double calculateAnnualSalary() {
        return (salary * 12) + bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Developer)){
            return false;
        }

        Developer d=(Developer) obj;
        return this.calculateAnnualSalary() == d.calculateAnnualSalary();
    }
}
