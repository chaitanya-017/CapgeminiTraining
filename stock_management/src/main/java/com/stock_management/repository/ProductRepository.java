package com.stock_management.repository;

import com.stock_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContaining(String name);
    List<Product> findByCategory(String category);
    List<Product> findByCompany(String company);
}