package com.stackroute.orderservice.cart.exception;

public class CartAlreadyExists extends RuntimeException{
    public CartAlreadyExists(String message) {
        super(message);
    }
}
