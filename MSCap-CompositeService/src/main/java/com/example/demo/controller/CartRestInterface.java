package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Cart;

@FeignClient(name="MS-CartService")
public interface CartRestInterface {
	
	@PostMapping("/addCart")
	public Cart fun1(@RequestBody Cart cart);
	
	@GetMapping("/getCart/{id}")
	public Cart fun2(@PathVariable int id);
	
	@DeleteMapping("/deleteCart/{id}")
	public void deleteCart(@PathVariable int id);
	
	@GetMapping("/getAllCart")
	public List<Cart> fun3();
	
	@PutMapping("/updateCart/{id}")
	public ResponseEntity<Object> fun4(@PathVariable int id,@RequestBody Cart cart);
	
	@PutMapping("/emptyCart/{id}")
	public String emptyCart(@PathVariable int id);

}
