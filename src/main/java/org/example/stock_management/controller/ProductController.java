package org.example.stock_management.controller;

import org.example.stock_management.entity.Product;
import org.example.stock_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product add(@RequestBody Product p) {
        return service.addProduct(p);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return service.search(name);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product p) {
        return service.updateProduct(id, p);
    }
}