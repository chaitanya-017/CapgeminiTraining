package com.stock_management.controller;

import com.stock_management.dto.OrderRequestDto;
import com.stock_management.entity.Order;
import com.stock_management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bill")
    public Order generateBill(@RequestBody OrderRequestDto request) {
        return service.generateBill(request);
    }
}