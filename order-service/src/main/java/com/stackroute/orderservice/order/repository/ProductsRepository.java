package com.stackroute.orderservice.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.orderservice.order.model.Products;

public interface ProductsRepository extends MongoRepository<Products,String> {

    public boolean existsByProductId(String productId);
    public Products findByProductId(String productId);
}
