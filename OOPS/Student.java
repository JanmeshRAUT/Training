package OOPS;

public class Student {
    String name;
    int RollNo;
    int Attendance;

    // Default Constructor
    Student() {
        name = "Unknown";
        RollNo = 0;
        Attendance = 0;
    }

    void iseligible() {
        if (Attendance > 75) {
            System.out.println(name + " is Eligible To Attend Class");
        } else {
            System.out.println(name + " is Not Eligible! Take Permission of HOD");
        }
    }
}