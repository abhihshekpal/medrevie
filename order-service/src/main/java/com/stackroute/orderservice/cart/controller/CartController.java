package com.stackroute.orderservice.cart.controller;

import com.stackroute.orderservice.cart.model.Cart;
import com.stackroute.orderservice.cart.model.Product;
import com.stackroute.orderservice.cart.repo.CartRepository;
import com.stackroute.orderservice.cart.service.CartService;

import com.stackroute.orderservice.cart.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;


//    @PostMapping("addCart")
//    public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
//        Cart add = cartService.saveCart(cart);
//        return  new ResponseEntity<Cart>(add, HttpStatus.ACCEPTED);
//
//    }

    @PutMapping("/addProduct/{email}")
    public ResponseEntity<Cart> addProduct(@RequestBody Product product, @PathVariable String email){
        Cart cart = cartService.addProduct(product,email);
        return new ResponseEntity<Cart>(cart,HttpStatus.ACCEPTED);
    }
        @PutMapping("setPrice")
        public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
            Cart updatedCart = cartService.setTotalPrice(cart);
            return new ResponseEntity<Cart>(updatedCart,HttpStatus.ACCEPTED);
        }
    

    @PutMapping("increaseQuantity/{productId}/{email}")
    public ResponseEntity<Cart> increaseQuantity(@PathVariable String productId, @PathVariable String email){
        Cart cart = cartService.increaseQuantity(productId, email);
        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }

    @PutMapping("decreaseQuantity/{productId}/{email}")
    public ResponseEntity<Cart> decreaseQuantity(@PathVariable String productId, @PathVariable String email){
        Cart cart = cartService.decreaseQuantity(productId, email);
        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }

    @GetMapping("/getCart/{email}")
    public ResponseEntity<Cart> getCart(@PathVariable String email){
        Cart cart =cartService.getCart(email);
        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }

    @PutMapping("deleteProduct/{email}")
    public ResponseEntity<Cart> deleteProduct(@RequestBody Product product, @PathVariable String email){
        Cart save = cartService.deleteProduct(product, email);
        return new ResponseEntity<Cart>(save,HttpStatus.OK);
    }

    @DeleteMapping("/deleteCart/{email}")
    public ResponseEntity<String> deleteCart(@PathVariable String email){
        String response = cartService.deleteCart(email);
        return new ResponseEntity<String>(response,HttpStatus.OK);
    }
}
