package com.stock_management.controller;

import com.stock_management.entity.Product;
import com.stock_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @GetMapping("/search/name")
    public List<Product> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/search/category")
    public List<Product> searchByCategory(@RequestParam String category) {
        return service.searchByCategory(category);
    }

    @GetMapping("/search/company")
    public List<Product> searchByCompany(@RequestParam String company) {
        return service.searchByCompany(company);
    }
}