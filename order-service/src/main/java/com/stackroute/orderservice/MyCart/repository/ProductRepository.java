package com.stackroute.orderservice.MyCart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.orderservice.order.model.Products;

public interface ProductRepository extends MongoRepository<Products,String> {

    public boolean existsByProductId(String productId);
    public Products findByProductId(String productId);
}
