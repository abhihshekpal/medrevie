package com.stackroute.orderservice.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String productId;
    private String name;
    private int quantity;
    private float price;
    private String image;


}