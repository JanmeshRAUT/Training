package Ecommerce;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flipkart flipkart = new Flipkart();
        int option = 0;
        while (option != 6) {
            System.out.println("1. Add Product in Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. Update Product in Cart");
            System.out.println("4. Search Product in Cart");
            System.out.println("5. Display Products in Cart");
            System.out.println("6. Exit");

            System.err.println("Enter your option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter product details: id, category, name, price");
                    int id = scanner.nextInt();
                    String category = scanner.next();
                    String name = scanner.next();
                    double price = scanner.nextDouble();
                    Product product1 = new Product(category, String.valueOf(id), name, price);
                    flipkart.addProduct(product1);
                    break;
                case 2:
                    int id2 = scanner.nextInt();
                    flipkart.removeProduct(id2);
                    break;
                case 3:
                    int id3 = scanner.nextInt();
                    String category3 = scanner.next();
                    String name3 = scanner.next();
                    double price3 = scanner.nextDouble();
                    Product newProduct = new Product(category3, String.valueOf(id3), name3, price3);
                    flipkart.updateProduct(id3, newProduct);
                    break;
                case 4:
                    String name4 = scanner.next();
                    flipkart.searchProduct(name4);
                    break;
                case 5:
                    flipkart.displayProducts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
