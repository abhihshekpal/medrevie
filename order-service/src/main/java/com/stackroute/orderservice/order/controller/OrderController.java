package com.stackroute.orderservice.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.stackroute.orderservice.order.model.Order;
import com.stackroute.orderservice.order.service.OrderService;
import com.stackroute.orderservice.orderexception.OrderNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/ord")
public class OrderController {

	@Autowired
	OrderService bs;

	@PostMapping("/order")
	Order createOrder(@RequestBody Order order) {
		return bs.save(order);
	}

	@GetMapping("/order/{id}")
	Order getOrder(@PathVariable int id) {
		Order ord = null;
		try {
			ord = bs.get(id);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
		}
		return ord;
	}

	@GetMapping("/order")
	Iterable<Order> getAllOrder() {
		return bs.getAll();
	}

	@DeleteMapping("/order/{id}")
	void delOrder(@PathVariable int id) {
		bs.delete(id);
	}

	@PutMapping("/order/{id}")
	Order updateOrder(@PathVariable int id, @RequestBody Order order) {
		Order newOrder = bs.updateOrder(id, order);
		return bs.save(newOrder);
	}

	@GetMapping("/orders/{name}")
	Iterable<Order> getByUserid(@PathVariable int name) {
		return bs.getByUserId(name);
	}
}