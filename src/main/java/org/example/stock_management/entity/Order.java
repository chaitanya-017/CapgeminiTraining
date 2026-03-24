package org.example.stock_management.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    private Double totalPrice;
    @Setter
    private Double totalPriceWithGst;

    public Integer getId() { return id; }

    public Double getTotalPrice() { return totalPrice; }

    public Double getTotalPriceWithGst() { return totalPriceWithGst; }
}