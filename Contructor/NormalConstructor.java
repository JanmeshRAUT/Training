public class NormalConstructor {
    String name;
    int age;

    // Normal (parameterized) constructor
    public NormalConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Default constructor
    public NormalConstructor() {
        this("Unknown", 0);
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        NormalConstructor p1 = new NormalConstructor("Alice", 30);
        NormalConstructor p2 = new NormalConstructor();
        p1.display();
        p2.display();
    }
}
