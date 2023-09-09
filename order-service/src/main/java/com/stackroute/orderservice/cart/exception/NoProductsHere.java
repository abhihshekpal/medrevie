package com.stackroute.orderservice.cart.exception;

public class NoProductsHere extends RuntimeException{
    public NoProductsHere(String message) {
        super(message);
    }
}
