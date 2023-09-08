package com.stackroute.orderservice.MyCart.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyCart {
	    private String cartId;
	    public MyCart(String cartId, String email, float totalPrice, List<Product> cartItems) {
			super();
			this.cartId = cartId;
			this.email = email;
			this.totalPrice = totalPrice;
			this.cartItems = cartItems;
		}
		public String getCartId() {
			return cartId;
		}
		public void setCartId(String cartId) {
			this.cartId = cartId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public float getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}
		public List<Product> getCartItems() {
			return cartItems;
		}
		public void setCartItems(List<Product> cartItems) {
			this.cartItems = cartItems;
		}
		private String email;
	    private float totalPrice;
	private List<Product> cartItems = new ArrayList<>();
	
	}



