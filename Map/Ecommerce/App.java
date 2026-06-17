package Map.Ecommerce;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Integer, Product> inventory = new HashMap<>();

        Product[] products = {
                new Product("Laptop", 999.99),
                new Product("Smartphone", 499.99),
                new Product("Headphones", 199.99)
        };

        int id = 1;
        for (Product p : products) {
            inventory.put(id++, p);
        }

        for (Map.Entry<Integer, Product> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}