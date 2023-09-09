package com.stackroute.orderservice.order.service;

import com.stackroute.orderservice.order.exception.OrderAlreadyExists;
import com.stackroute.orderservice.order.exception.OrderDoesnotExist;
import com.stackroute.orderservice.order.model.Order;
import com.stackroute.orderservice.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order){

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrder(String email){
        List<Order> order = orderRepository.findByEmail(email);
        if(order==null){
            throw new OrderDoesnotExist("Order doesnot exist");
        }
        return order;
    }

    @Override
    public String deleteOrder(String orderId){
        if (!orderRepository.existsById(orderId)){
            throw new OrderDoesnotExist("Order doesnot exist");
        }
        orderRepository.deleteById(orderId);
        return "Order deleted";
    }


}
