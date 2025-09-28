package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.*;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addOrder")
	public Order fun1(@RequestBody Order order) {
		return orderService.insertOrder(order);
	}
	
	@GetMapping("/getOrder/{id}")
	public Order fun2(@PathVariable int id) throws OrderNotFoundException {
		return orderService.getOrder(id);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable int id) throws OrderNotFoundException {
		orderService.deleteOrder(id);
	}
	
	@GetMapping("/getAllOrder")
	public List<Order> fun3(){
		return orderService.getAllOrder();
	}

}
