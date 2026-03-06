package com.example.UrbanCart.dto;

import java.util.Map;

public class OrderRequest {
    private Map<Long,Integer>quantities;
    private double totalAmount;

    public Map<Long, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Long, Integer> quantities) {
        this.quantities = quantities;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
