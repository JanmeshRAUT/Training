package Employee;

public class App {
    public static void main(String[] args){
        Employee Janmesh=new Employee(true, 5, 9.5, "Employee");
        System.out.println("Before updating working days and appraisal:");
        Janmesh.showEmployeeDetails();
        
        Employee Ramesh=new Employee(true, 10, 9.8, "Manager");
        
        Employee Suresh=new Employee(true, 15, 9.9, "Director");
 

        Suresh.updateEmployeeAppraisal(Janmesh, 9.7);
        System.out.println("After updating appraisal by Director:");
        Janmesh.showEmployeeDetails();

    }
}
