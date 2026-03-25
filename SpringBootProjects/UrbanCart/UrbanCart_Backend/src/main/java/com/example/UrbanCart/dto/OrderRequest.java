package com.example.UrbanCart.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public class OrderRequest {
    @NotNull(message = "User id cannont be null")
    private Long userId;

    @NotNull(message = "Products cannot be null")
    @NotEmpty(message = "atleast 1 product shld be ordered")
    private Map<@NotNull(message = "cannot be emptey") Long,@NotNull(message = "quantities cannot be null") @Min(value = 1,message = "value cannot be less than 1") Integer>quantities;


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
