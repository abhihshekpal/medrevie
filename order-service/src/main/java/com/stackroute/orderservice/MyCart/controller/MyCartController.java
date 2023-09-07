package com.stackroute.orderservice.MyCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.orderservice.MyCart.model.MyCart;
import com.stackroute.orderservice.MyCart.service.MyCartService;

@RestController
@RequestMapping("/cart")
public class MyCartController {

	@Autowired
	MyCartService bs;

	@PostMapping("/mycart")
	MyCart createmycart(@RequestBody MyCart mycart) {
		return bs.save(mycart);
	}

	@GetMapping("/mycart/{id}")
	Iterable<MyCart> getmycart(@PathVariable int id) {
		return bs.get(id);
	}

	@DeleteMapping("/mycart/{id}")
	void delMyCart(@PathVariable int id) {
		bs.delete(id);
	}

	@GetMapping("/mycart")
	Iterable<MyCart> getAll() {
		return bs.getAll();
	}
	@PutMapping("/cart/{id}")
	MyCart updateMyCart (@PathVariable int id, @RequestBody MyCart  mycart) {
		MyCart newMyCart = bs.updateMyCart (id, mycart);
		return bs.save(newMyCart);
	}
	@GetMapping("/MyCart/{name}")
	Iterable<MyCart> getByProductId(@PathVariable int name) {
		return bs.getByProductId(name);
	}
}
