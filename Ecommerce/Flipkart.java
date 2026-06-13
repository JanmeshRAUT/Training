package Ecommerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Flipkart {
    List<Product> productList=new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }


    public int removeProduct(int id){
        for (Product product : productList) {
            if (product.getId().equals(String.valueOf(id))) {
                productList.remove(product);
                return id;
            }
        }
        return -1;
    }
    public List<Product> getProductList() {
        return productList;
    }

    public List<Product> sortProductsbyName(){
        Collections.sort(productList, Comparator.comparing(Product::getName));
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
    public Product searchProduct(String name){
        for(Product product:productList){
            if(product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    public void displayProducts(){
        for(Product product:productList){
            System.out.println(product);
        }
    }

}
