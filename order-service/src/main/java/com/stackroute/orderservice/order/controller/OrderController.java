package com.stackroute.orderservice.order.controller;

import com.stackroute.orderservice.cart.model.Cart;
import com.stackroute.orderservice.order.model.Order;
import com.stackroute.orderservice.order.model.Products;
import com.stackroute.orderservice.order.repo.OrderRepository;
import com.stackroute.orderservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/saveOrder")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        Order saved = orderService.saveOrder(order);
        return  new ResponseEntity<Order>(saved, HttpStatus.ACCEPTED);
    }

    @GetMapping("/allOrder/{email}")
    public ResponseEntity<List<Order>> allOrder(@PathVariable String email){
        List<Order> orderList = orderService.getOrder(email);
        return  new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
    }

    


}
