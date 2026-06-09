import java.util.Scanner;

public class ProductCatalog {

    static void ProductPrice(String prodString[], double price[], String productName) {
        for (int i = 0; i < prodString.length; i++) {
            if (prodString[i].equalsIgnoreCase(productName)) {
                System.out.println("Price of " + productName + ": " + price[i]);
            }
        }
    }

    static void MostExpensive(String product[], double price[]) {
        int maxPrice = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[maxPrice]) {
                maxPrice = i;
            }
        }

        System.out.println("Highest Price Product: "
                + product[maxPrice] + " - " + price[maxPrice]);
    }

    static void cheapest(String prodString[], double price[]) {
        int minPrice = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] < price[minPrice]) {
                minPrice = i;
            }
        }

        System.out.println("Cheapest Product: "
                + prodString[minPrice] + " - " + price[minPrice]);
    }

    static void Product(String name, String product[]) {
        for (String prodName : product) {
            if (prodName.equalsIgnoreCase(name)) {
                System.out.println("Found: " + name);
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    static void calculate(double price[]) {
        double sum = 0;

        for (double p : price) {
            sum += p;
        }

        System.out.println("Total Inventory Value: " + sum);
    }

    static void searchByChar(String ch, String prodString[]) {
        
        for (String name : prodString) {
            if(name.contains(ch)){
                System.out.println("Product:"+name);
            }
        }
    }

    public static void main(String[] args) {

        String product[] = {
                "Laptop",
                "Mouse",
                "Keyboard",
                "Monitor",
                "Phone"
        };

        double price[] = {
                50000.0,
                500.0,
                1500.0,
                12000.0,
                30000.0
        };

        ProductPrice(product, price, "Laptop");
        MostExpensive(product, price);
        cheapest(product, price);
        Product("Mouse", product);
        calculate(price);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Char");
        String ch=sc.next();
        searchByChar(ch, product);
    }
}