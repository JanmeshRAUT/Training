package Map.Swiggy;

public class Order {
    private int id;
    private int customerId;
    private String productName;
    private double price;

    public Order(int id, int customerId, String productName, double price) {
        this.id = id;
        this.customerId = customerId;
        this.productName = productName;
        this.price = price;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", productName=").append(productName);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
