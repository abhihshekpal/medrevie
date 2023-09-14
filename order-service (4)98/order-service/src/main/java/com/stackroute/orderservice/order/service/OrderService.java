package com.stackroute.orderservice.order.service;

import com.stackroute.orderservice.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public Order saveOrder(Order order);

    List<Order> getOrder(String email);

    String deleteOrder(String orderId);
}
