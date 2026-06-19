package com.example.JerryJR.services;

import com.example.JerryJR.entity.Product;
import com.example.JerryJR.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product updateProduct(Long id,Product product) {

        Product oldProduct = productRepository.findById(id).orElse(null);

        if(oldProduct != null) {
            oldProduct.setProductName(product.getProductName());
            oldProduct.setProductPrice(product.getProductPrice());
            oldProduct.setStock(product.getStock());
            oldProduct.setCategory(product.getCategory());

            return productRepository.save(oldProduct);
        } else {
            return null;
        }

    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }


    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.deleteById(id);
            return product;
        }
        return null;
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

}
