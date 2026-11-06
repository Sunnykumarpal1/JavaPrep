package com.example.UrbanCart.Mapper;

import com.example.UrbanCart.dto.OrderDTO;
import com.example.UrbanCart.dto.OrderItemsDTO;
import com.example.UrbanCart.entity.OrderItems;
import com.example.UrbanCart.entity.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrderMapping {
    public OrderDTO toOrderDTO(Orders orders){
        OrderDTO orderDTO=new OrderDTO(orders.getId(),orders.getOrderDate(), orders.getTotalAmount(),orders.getOrderStatus() ,orders.getUser().getId(),orders.getOrderItems().stream().map(this::toOrderItemDTO).toList());
        return orderDTO;
    }

    public OrderItemsDTO toOrderItemDTO(OrderItems orderItems){
        return new OrderItemsDTO(orderItems.getProduct().getName(),orderItems.getProduct().getPrice(),orderItems.getQuantity());
    }
}
