package com.stock_management.service;

import com.stock_management.entity.Product;
import com.stock_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product updateProduct(int id, Product updated) {
        Product product = repo.findById(id).orElseThrow();
        product.setName(updated.getName());
        product.setCategory(updated.getCategory());
        product.setCompany(updated.getCompany());
        product.setQuantity(updated.getQuantity());
        product.setPrice(updated.getPrice());
        return repo.save(product);
    }

    public List<Product> searchByName(String name) {
        return repo.findByNameContaining(name);
    }

    public List<Product> searchByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> searchByCompany(String company) {
        return repo.findByCompany(company);
    }
}