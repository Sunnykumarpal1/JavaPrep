package com.example.UrbanCart.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private double totalAmount;
    private String orderStatus;
    private Long userId;
    private List<OrderItemsDTO>orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long id, LocalDateTime orderDate, double totalAmount, String orderStatus, Long userId, List<OrderItemsDTO> orderItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemsDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
