package Polymorphism;

public class Delivery {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Car();
        Vehicle vehicle3 = new Bike();
        Vehicle vehicle4 = new Drone();
        vehicle1.Drive();
        vehicle2.Drive();
        vehicle3.Drive();
        vehicle4.Drive();
        
    }
}
