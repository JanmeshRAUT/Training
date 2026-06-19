package com.example.JerryJR.controller;

import com.example.JerryJR.entity.Product;
import com.example.JerryJR.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    public List<Product> getProducts(){
        return productServices.findAll();
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Long id){
        return productServices.findById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productServices.addProduct(product);
    }
    @PostMapping("/saveAll")
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productServices.saveAll(products);
    }
    @PutMapping
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product){
        return productServices.updateProduct(id,product);
    }
    @DeleteMapping
    public void deleteProduct(@PathVariable Long id){
        productServices.deleteProduct(id);
    }

}
