package Ecommerce;

public class Product {
    private String id;
    private String category;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String category, String name, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + "]";
    }



    
}
