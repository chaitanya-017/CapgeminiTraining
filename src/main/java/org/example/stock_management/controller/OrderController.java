package org.example.stock_management.controller;

import org.example.stock_management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Object Ordercreate(@RequestBody List<Integer> productIds) {
        return service.createOrder(productIds);
    }
}