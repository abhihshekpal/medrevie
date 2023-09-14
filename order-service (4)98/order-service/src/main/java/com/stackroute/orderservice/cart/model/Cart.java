package com.stackroute.orderservice.cart.model;

import com.stackroute.orderservice.order.model.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Cart {

    @Id
    private String cartId ;
    private String email;
    private float totalPrice;
    private List<Product> cartItems = new ArrayList<>();


}
