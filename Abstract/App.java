package Abstract;

public class App {
    public static void main(String[] args) {
        Employee d = new Developer(100000, "D101", "Rahul", 50000);
        Employee d2=new Developer(5800, "D500", "Nitin", 50000);
        Employee h = new Hr(50000, "H101", "Priya", 40000);
        Employee m = new Marketing(75000, "M101", "Amit", 45000);

        System.out.println(d.equals(d2));

        System.out.println("Developer Annual Salary: " + d.calculateAnnualSalary());
        System.out.println("HR Annual Salary: " + h.calculateAnnualSalary());
        System.out.println("Marketing Annual Salary: " + m.calculateAnnualSalary());
    }
}