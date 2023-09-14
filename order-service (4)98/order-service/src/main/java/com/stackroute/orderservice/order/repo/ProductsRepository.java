package com.stackroute.orderservice.order.repo;

import com.stackroute.orderservice.order.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products,String> {

    public boolean existsByProductId(String productId);
    public Products findByProductId(String productId);
}
