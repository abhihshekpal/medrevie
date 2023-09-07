package com.stackroute.orderservice.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private int orderId;
	private Date datetime;
	private int userId;
	private String orderStatus;
	private double paymentAmount;
	private String paymentMethod;
	private List<Products> orderItems= new ArrayList<>();
	public List<Products> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Products> orderItems) {
		this.orderItems = orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order(int orderId, Date datetime, int userId, String orderStatus, double paymentAmount, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.datetime = datetime;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
	}

}

