package com.stackroute.orderservice.order.exception;

public class OrderDoesnotExist extends RuntimeException{
    public OrderDoesnotExist(String message) {

        super(message);
    }
}