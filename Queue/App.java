package Queue;

import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Operation operation = new Operation();

        Patient patient1 = new Patient("P001", "Janmesh", 30, "Flu");
        Patient patient2 = new Patient("P002", "Jerry", 25, "Cold");
        Patient patient3 = new Patient("P003", "Alice", 40, "Headache");

        operation.addPatient(patient1);
        operation.addPatient(patient2);
        operation.addPatient(patient3);
        operation.displayQueue();

        Patient[] newPatients = {
                new Patient("P004", "Bob", 35, "Fever"),
                new Patient("P005", "Charlie", 28, "Cough"),
                new Patient("P006", "David", 50, "Back Pain"),
                new Patient("P007", "Eva", 22, "Allergy")
        };
        operation.multiplePatients(newPatients);
        operation.displayQueue();

        operation.callNextPatient();
        System.out.println("\nAfter Treating The Patient:");
        operation.displayQueue();

        System.out.println("\nViewing the next patient :");
        operation.viewNextPatient();

        operation.clearQueue();
        operation.displayQueue();

        System.out.println("\nAdding new patients to the queue:");

        Collections.sort(operation, new SortByPatientName());
        System.out.println("===================Sorted on basis of ID=============");
        System.out.println(line);
    }
}
