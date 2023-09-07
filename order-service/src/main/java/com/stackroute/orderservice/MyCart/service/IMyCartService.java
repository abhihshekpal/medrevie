package com.stackroute.orderservice.MyCart.service;

import com.stackroute.orderservice.MyCart.model.MyCart;


public interface IMyCartService {
	MyCart save(MyCart mycart);

	Iterable<MyCart> get(int id);

	void delete(int id);

	Iterable<MyCart> getAll();

	Iterable<MyCart> getByProductId(int productid);
	MyCart updateMyCart(int id, MyCart mycart);

}
