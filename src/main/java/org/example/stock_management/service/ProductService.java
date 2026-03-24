package org.example.stock_management.service;

import org.example.stock_management.entity.Product;
import org.example.stock_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product addProduct(Product p) {
        return repo.save(p);
    }

    public List<Product> search(String name) {
        return repo.findByNameContaining(name);
    }

    public Product updateProduct(Integer id, Product p) {
        Product existing = repo.findById(id).orElseThrow();

        existing.setName(p.getName());
        existing.setCategory(p.getCategory());
        existing.setCompany(p.getCompany());
        existing.setQuantity(p.getQuantity());
        existing.setPrice(p.getPrice());

        return repo.save(existing);
    }
}