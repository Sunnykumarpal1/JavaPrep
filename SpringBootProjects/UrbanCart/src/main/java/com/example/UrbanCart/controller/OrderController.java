package com.example.UrbanCart.controller;

import com.example.UrbanCart.dto.OrderDTO;
import com.example.UrbanCart.dto.OrderItemsDTO;
import com.example.UrbanCart.dto.OrderRequest;
import com.example.UrbanCart.entity.OrderItems;
import com.example.UrbanCart.entity.Orders;
import com.example.UrbanCart.entity.Product;
import com.example.UrbanCart.entity.User;
import com.example.UrbanCart.repository.ProductRepostiory;
import com.example.UrbanCart.repository.UserRepository;
import com.example.UrbanCart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping
    OrderDTO placeOrder(@RequestBody OrderRequest orderRequest){
         return orderService.placeOrder(orderRequest);
    }
//
//    @PostMapping("/{userId}")
//    List<OrderDTO>getAllOrderByUser(@PathVariable("userId")Long userId){
//        List<Orders>allOrders=orderService.getAllOrderByUserId(userId);
//
//    }
}
