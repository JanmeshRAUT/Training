package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Operation {
    Queue<Patient> patientQueue=new LinkedList<>();

    public void addPatient(Patient patient){
        patientQueue.add(patient);
    }

    public void multiplePatients(Patient[] patients){
        for (Patient patient : patients) {
            addPatient(patient);
        }
    }

    public void callNextPatient(){
        if (!patientQueue.isEmpty()){
            Patient nextPatient=patientQueue.poll();
            System.out.println("Next patient: "+nextPatient);
        }else {
            System.out.println("No Patients");
        }
    }

    public void viewNextPatient(){
        if (!patientQueue.isEmpty()){
            Patient nextPatient=patientQueue.peek();
            System.out.println("Next patient: "+nextPatient);
        }else {
            System.out.println("No patients.");
        }
    }

    public void displayQueue(){
        if (patientQueue.isEmpty()){
            System.out.println("No patients.");
        }else {
            System.out.println("Current patient queue:");
            for (Patient patient : patientQueue) {
                System.out.println(patient);
            }
        }
    }
    public void viewNewPatient(){
        if (!patientQueue.isEmpty()){
            Patient newPatient=patientQueue.peek();
            System.out.println("New patient: "+newPatient);
        }else {
            System.out.println("No patients in the queue.");
        }
    }

    public void clearQueue(){
        patientQueue.clear();
        System.out.println("Patient queue cleared.");
    }


}
