package com.example.UrbanCart.service;

import com.example.UrbanCart.Exception.InsufficientItemException;
import com.example.UrbanCart.Exception.ProductNotFoundException;
import com.example.UrbanCart.Exception.UserNotFoundException;
import com.example.UrbanCart.Mapper.OrderMapping;
import com.example.UrbanCart.dto.OrderDTO;
import com.example.UrbanCart.dto.OrderItemsDTO;
import com.example.UrbanCart.dto.OrderRequest;
import com.example.UrbanCart.entity.OrderItems;
import com.example.UrbanCart.entity.Orders;
import com.example.UrbanCart.entity.Product;
import com.example.UrbanCart.entity.User;
import com.example.UrbanCart.repository.OrderRepository;
import com.example.UrbanCart.repository.ProductRepostiory;
import com.example.UrbanCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private UserRepository userRepository;

    private ProductRepostiory productRepostiory;

    private OrderRepository orderRepository;

    private OrderMapping orderMapping;

    public OrderService(UserRepository userRepository, ProductRepostiory productRepostiory, OrderRepository orderRepository, OrderMapping orderMapping) {
        this.userRepository = userRepository;
        this.productRepostiory = productRepostiory;
        this.orderRepository = orderRepository;
        this.orderMapping = orderMapping;
    }

    @Transactional
    public OrderDTO placeOrder(OrderRequest orderRequest) {
        Long userId=orderRequest.getUserId();
        User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Not found Exception"));
        Map<Long,Integer> products=orderRequest.getQuantities();
        Orders orders=new Orders();

        orders.setOrderDate(LocalDateTime.now());
        orders.setUser(user);
        orders.setOrderStatus("Pending");

        List<OrderItems> orderItems=new ArrayList<>();
        List<OrderItemsDTO>orderItemsDTOS=new ArrayList<>();

        Double totalSum=0.0;
        for(Map.Entry<Long,Integer>items:products.entrySet()){
            Product product=productRepostiory.findById(items.getKey()).orElseThrow(()->new ProductNotFoundException("Product not found excetpion"));
            if(product.getStockQuantity()>= items.getValue()){
                totalSum+=(product.getPrice()*items.getValue());
                OrderItems orderItem=new OrderItems();
                orderItem.setOrders(orders);
                orderItem.setProduct(product);
                orderItem.setQuantity(items.getValue());
                orderItems.add(orderItem);
                orderItemsDTOS.add(new OrderItemsDTO(product.getName(),product.getPrice(),items.getValue()));
//                now since we ahave ordered the items it count will reduce
                product.setStockQuantity(product.getStockQuantity()- items.getValue());
//                productRepostiory.save(product);
            }else {
                 throw  new InsufficientItemException("Product with id "+items.getKey().toString()+" with quantity "+items.getValue().toString()+" Insufficient ");
            }


        }
        orders.setTotalAmount(totalSum);
        orders.setOrderItems(orderItems);
        Orders savedOrder=orderRepository.save(orders);

        return new OrderDTO(savedOrder.getId(),savedOrder.getOrderDate(), savedOrder.getTotalAmount(), savedOrder.getOrderStatus(),userId,orderItemsDTOS);
    }

    public List<OrderDTO> getAllOrderByUserId(Long userId) {
         List<Orders>list= orderRepository.findByUserId(userId);
         List<OrderDTO>orderDTOS=list.stream().map(e->orderMapping.toOrderDTO(e)).toList();
         return orderDTOS;
    }

    public List<OrderDTO> getAllOrders() {
//        List<Orders>orders=orderRepository.findAll();
        List<Orders>orders=orderRepository.getOrderByUser();
        List<OrderDTO>orderDTOS=orders.stream().map(e->orderMapping.toOrderDTO(e)).toList();
        return orderDTOS;
    }
}
