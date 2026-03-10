package com.example.UrbanCart.dto;

import com.example.UrbanCart.entity.Product;

public class OrderItemsDTO {
    private String productName;
    private Double productPrice;
    private  Integer quantity;

    public OrderItemsDTO(String productName, Double productPrice, Integer quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
