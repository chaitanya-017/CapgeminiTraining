package com.stock_management.service;

import com.stock_management.dto.CartItem;
import com.stock_management.dto.OrderRequestDto;
import com.stock_management.entity.Order;
import com.stock_management.entity.OrderHistory;
import com.stock_management.entity.Product;
import com.stock_management.repository.OrderHistoryRepository;
import com.stock_management.repository.OrderRepository;
import com.stock_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderHistoryRepository historyRepo;

    public Order generateBill(OrderRequestDto request) {

        double total = 0;

        Order order = new Order();

        for (CartItem item : request.getItems()) {

            Product product = productRepo.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for " + product.getName());
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepo.save(product);

            total += product.getPrice() * item.getQuantity();
        }

        double gst = total * 0.18;
        double finalAmount = total + gst;

        order.setTotalPrice(total);
        order.setTotalPriceWithGst(finalAmount);

        Order savedOrder = orderRepo.save(order);

        // Save history
        for (CartItem item : request.getItems()) {
            OrderHistory history = new OrderHistory();
            history.setOrderId(savedOrder.getId());
            history.setProductId(item.getProductId());
            historyRepo.save(history);
        }

        return savedOrder;
    }
}