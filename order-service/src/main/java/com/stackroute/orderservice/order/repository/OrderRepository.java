package com.stackroute.orderservice.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.orderservice.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

	Iterable<Order> findByUserId(int userid);

}
