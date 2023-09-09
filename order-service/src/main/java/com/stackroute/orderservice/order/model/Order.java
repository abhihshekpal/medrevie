package com.stackroute.orderservice.order.model;

import com.stackroute.orderservice.order.model.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {

    @Id
    private String orderId;
    private String email;
    private String purchaseDate;
    private float totalPrice;
    private String deliveryStatus;
    private String expectedDelivery;

    private List<Products> orderItems= new ArrayList<>();






}
