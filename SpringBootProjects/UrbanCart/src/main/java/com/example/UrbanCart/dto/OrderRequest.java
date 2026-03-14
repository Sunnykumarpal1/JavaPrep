package com.example.UrbanCart.dto;

import java.util.Map;

public class OrderRequest {
    private Long userId;
    private Map<Long,Integer>quantities;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Long, Integer> quantities) {
        this.quantities = quantities;
    }
}
