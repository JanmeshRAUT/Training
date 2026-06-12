package Ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {
    Product product;
    List<Product> productList=new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }
    public void removeProduct(int id){
        for (Product product : productList) {
            if (product.getId().equals(String.valueOf(id))) {
                productList.remove(product);
                break;
            }
        }
    }
    public List<Product> getProductList() {
        return productList;
    }
    public void updateProduct(int id, Product newProduct){
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId().equals(String.valueOf(id))) {
                productList.set(i, newProduct);
                break;
            }
        }
    }
    public void searchProduct(String name){
        for(Product product:productList){
            if(product.getName().equalsIgnoreCase(name)){
                System.out.println(product);
            }
        }
    }

    public void displayProducts(){
        for(Product product:productList){
            System.out.println(product);
        }
    }

}
