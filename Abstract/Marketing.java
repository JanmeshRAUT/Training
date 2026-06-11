package Abstract;

public class Marketing extends Employee{
    double incentive;

    public Marketing(double incentive, String id, String name, double salary) {
        super(id, name, salary);
        this.incentive = incentive;
    }

    @Override
    double calculateAnnualSalary(){
        return (salary *12)+incentive;
    }


}
