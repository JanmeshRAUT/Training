package Employee;

public class Employee {
    private boolean insurance;
    private int workDays;
    private double appraisal;
    private String role;

    Employee(boolean insurance, int workDays, double appraisal, String role) {
        this.insurance = insurance;
        this.workDays = workDays;
        this.appraisal = appraisal;
        this.role = role;
    }

    void UpdateWorkingDays(int workDays, String role) {
        if (role.equals("Manager") || role.endsWith("Director")) {
            this.workDays = workDays;
        }
    }

    void UpdateAppraisal(double appraisal, String role) {
        if (role.equals("Director")) {
            this.appraisal = appraisal;
        }
    }

    void updateEmployeeAppraisal(Employee emp, double appraisal) {
        if (this.role.equals("Director")) {
            emp.appraisal = appraisal;
        } else {
            System.out.println("Only Directors can update employee appraisals.");
        }
    }

    void showEmployeeDetails() {
        System.out.println("Employee Role: " + role);
        System.out.println("Employee Insurance: " + insurance);
        System.out.println("Employee Work Days: " + workDays);
        System.out.println("Employee Appraisal: " + appraisal);
    }
}
