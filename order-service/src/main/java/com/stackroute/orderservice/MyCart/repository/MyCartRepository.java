
package com.stackroute.orderservice.MyCart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.orderservice.MyCart.model.MyCart;

public interface MyCartRepository  extends MongoRepository<MyCart, Integer> {
	Iterable<MyCart> findByProductId(int productid);
	
	public MyCart findByEmail(String email);
    //public boolean existsByEmail(String email);
}
