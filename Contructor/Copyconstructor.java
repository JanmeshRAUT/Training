package Contructor;

public class Copyconstructor {
    String name;
    int price;

    Copyconstructor(String name, int price) {
        this.name = name;
        this.price = price;
    }
    Copyconstructor(Copyconstructor p) {
        this.name = p.name;
        this.price = p.price;
    }
}
