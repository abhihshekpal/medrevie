package com.stackroute.orderservice.cart.repo;

import com.stackroute.orderservice.cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {

    public Cart findByEmail(String email);
    public boolean existsByEmail(String email);
}
