package com.stackroute.orderservice.order.service;

import com.stackroute.orderservice.order.model.Order;
import com.stackroute.orderservice.orderexception.OrderNotFoundException;

public interface IOrderService {
	Order save(Order order);

	Order get(int id) throws OrderNotFoundException;

	void delete(int id);

	Iterable<Order> getAll();

	Iterable<Order> getByUserId(int name);

	Order updateOrder(int id, Order order);
}
