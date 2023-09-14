package com.stackroute.orderservice.cart.repo;

import com.stackroute.orderservice.cart.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

}
