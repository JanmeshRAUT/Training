package Contructor;

public class index {
    public static void main(String[] args) {
        Copyconstructor c1 = new Copyconstructor("SBI", 1000);
        Copyconstructor c2 = new Copyconstructor(c1);
        System.out.println("Bank Name: " + c2.name);
        System.out.println("Balance: " + c2.price);
    }
}
