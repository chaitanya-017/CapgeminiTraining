package com.stock_management.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequestDto {
    private List<CartItem> items;

    // Getters & Setters
}