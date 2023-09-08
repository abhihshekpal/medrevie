package com.stackroute.orderservice.cart.service;

import com.stackroute.orderservice.cart.model.Cart;
import com.stackroute.orderservice.cart.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
//   public Cart saveCart(Cart cart);

	Cart addProduct(Product product, String email);

	Cart deleteProduct(Product product, String email);

	Cart increaseQuantity(String productId, String email);

	Cart decreaseQuantity(String productId, String email);

	Cart getCart(String email);

	String deleteCart(String email);

	Cart setTotalPrice(Cart cart);
}
