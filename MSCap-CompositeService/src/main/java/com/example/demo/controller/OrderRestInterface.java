package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Order;

@FeignClient(name="MS-OrderService")
public interface OrderRestInterface {
	
	@PostMapping("/addOrder")
	public Order fun1(@RequestBody Order order);
	
	@GetMapping("/getOrder/{id}")
	public Order fun2(@PathVariable int id);
	
	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable int id);
	
	@GetMapping("/getAllOrder")
	public List<Order> fun3();

}
