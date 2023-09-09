package com.stackroute.orderservice.cart.exception;

public class CartDoesnotExist extends RuntimeException{
    public CartDoesnotExist(String message) {
        super(message);
    }
}
