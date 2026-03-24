package org.example.stock_management.service;

import org.example.stock_management.entity.*;
import org.example.stock_management.repository.*;
import org.example.stock_management.entity.Order;
import org.example.stock_management.entity.OrderHistory;
import org.example.stock_management.entity.Product;
import org.example.stock_management.repository.OrderHistoryRepository;
import org.example.stock_management.repository.OrderRepository;
import org.example.stock_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderHistoryRepository historyRepo;

    public Order createOrder(List<Integer> productIds) {

        double total = 0;

        for (Integer id : productIds) {
            Product p = productRepo.findById(id).orElseThrow();

            if (p.getQuantity() <= 0) {
                throw new RuntimeException("Out of stock");
            }

            total += p.getPrice();
            p.setQuantity(p.getQuantity() - 1);
            productRepo.save(p);
        }

        Order order = new Order();
        order.setTotalPrice(total);
        order.setTotalPriceWithGst(total * 1.18);

        Order saved = orderRepo.save(order);

        for (Integer id : productIds) {
            OrderHistory oh = new OrderHistory();
            oh.setOrderId(saved.getId());
            oh.setProductId(id);
            historyRepo.save(oh);
        }

        return saved;
    }
}