package com.stackroute.orderservice.MyCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.orderservice.MyCart.model.MyCart;
import com.stackroute.orderservice.MyCart.model.Product;
import com.stackroute.orderservice.MyCart.repository.MyCartRepository;

@Service
public class MyCartService implements IMyCartService {
	@Autowired
	MyCartRepository br;

	@Override
	public MyCart save(MyCart mycart) {
		return br.save(mycart);
	}

	@Override
	public Iterable<MyCart> get(int productid) {
		return br.findByProductId(productid);
	}

	@Override
	public void delete(int productid) {
		br.deleteById(productid);
	}

	@Override
	public Iterable<MyCart> getAll() {
		return br.findAll();
	}

	@Override
	public MyCart updateMyCart(int id, MyCart mycart) {
		MyCart newMyCart = br.findById(id).get();
		newMyCart.setid(mycart.getid());
		newMyCart.setProductName(mycart.getProductName());
		newMyCart.setProductId(mycart.getProductId());
		newMyCart.setQuantity(mycart.getQuantity());
		newMyCart.setPaymentAmount(mycart.getPaymentAmount());
		newMyCart.setPaymentMethod(mycart.getPaymentMethod());
		return br.save(newMyCart);
	}

	@Override
	public Iterable<MyCart> getByProductId(int productid) {
		return br.findByProductId(productid);
	}

    }

