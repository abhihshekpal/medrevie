package com.stackroute.orderservice.MyCart.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyCart {
	private int id;
	private int productId;
	private String productName;
	private int quantity;
	private String email;
	private double paymentAmount;
	private String paymentMethod;
	private List<Product> cartItems = new ArrayList<>();
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getEmail() {
		return email;
	}

	public List<Product> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Product> cartItems) {
		this.cartItems = cartItems;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public MyCart(int id, int productId, String productName, int quantity, double paymentAmount, String paymentMethod) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
	}}

