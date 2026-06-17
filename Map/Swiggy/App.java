package Map.Swiggy;

public class App {
    public static void main(String[] args) {
        Managment managment = new Managment();

        Customer customer1 = new Customer("JerryJR@gmail.com", 1, "Jerry");
        Customer customer2 = new Customer("tommy@gmail.com", 2,"TommyT");
        Customer customer3 = new Customer("bob@gmail.com", 3,"BobB");
        Customer customer4 = new Customer("alice@gmail.com", 4,"AliceA");
        Customer customer5 = new Customer("nina@gmail.com", 5,"NinaN");

        managment.addCustomer(customer1);
        managment.addCustomer(customer2);
        managment.addCustomer(customer3);
        managment.addCustomer(customer4);
        managment.addCustomer(customer5);

        Order order1 = new Order(1, 1, "Pizza", 12.99);
        Order order2 = new Order(2, 2, "Burger", 8.99);
        Order order3 = new Order(3, 1, "Pasta", 10.99);
        Order order4 = new Order(4, 3, "Salad", 6.99);
        Order order5 = new Order(5, 4, "Sandwich", 7.49);
        Order order6 = new Order(6, 5, "Noodles", 11.25);
        Order order7 = new Order(7, 5, "Coffee", 3.99);

        managment.placeOrder(order1);
        managment.placeOrder(order2);
        managment.placeOrder(order3);
        managment.placeOrder(order4);
        managment.placeOrder(order5);
        managment.placeOrder(order6);
        managment.placeOrder(order7);

        System.out.println("--- Display Customers Using EntrySet ---");
        managment.displayCustomers();

        System.out.println("--- Display Customers Using For-Each ---");
        managment.displayCustomerbyFor();

        System.out.println("--- Display All Orders ---");
        managment.displayOrders();

        System.out.println("--- Orders For Customer 1 ---");
        managment.displayOrdersByCustomer(1);

        System.out.println("--- Total Revenue ---");
        managment.displayTotalRevenue();

        System.out.println("--- Revenue By Customer 5 ---");
        managment.calRevenuebyCustomer(5);

        System.out.println("--- Highest Spending Customer ---");
        managment.displayHighestSpendigCustomers();

        System.out.println("--- Orders Per Customer ---");
        managment.countOrdersPerCustomer();

        System.out.println("--- Removing Customer 3 ---");
        managment.removeCustomer(3);

        System.out.println("--- Customers After Removal ---");
        managment.displayCustomerbyFor();

        System.out.println("--- Orders After Removal ---");
        managment.displayOrders();
    }
}
