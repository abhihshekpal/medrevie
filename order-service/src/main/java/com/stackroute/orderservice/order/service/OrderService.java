package com.stackroute.orderservice.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.orderservice.order.model.Order;
import com.stackroute.orderservice.order.repository.OrderRepository;
import com.stackroute.orderservice.orderexception.OrderNotFoundException;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository br;

	@Override
	public Order save(Order order) {
		return br.save(order);
	}

	@Override
	public Order get(int userid) throws  OrderNotFoundException{
		if(!br.existsById(userid)) {
			throw new OrderNotFoundException();
		}
		return br.findById(userid).get();
		
	}

	@Override
	public void delete(int userid) {
		br.deleteById(userid);
		
	}
	@Override
	public Iterable<Order> getAll() {
		return br.findAll();
	}
	@Override
	public Order updateOrder(int id, Order order) {
		Order newOrder=br.findById(id).get();
		newOrder.setId(order.getId());
        newOrder.setOrderId(order.getOrderId());
        newOrder.setDatetime(order.getDatetime());
        newOrder.setUserId(order.getUserId());
        newOrder.setOrderStatus(order.getOrderStatus());
        newOrder.setPaymentAmount(order.getPaymentAmount());
        newOrder.setPaymentMethod(order.getPaymentMethod());
        return br.save(newOrder);
    }
	@Override
	public Iterable<Order> getByUserId(int userid) {
		return br.findByUserId(userid);
	}

}