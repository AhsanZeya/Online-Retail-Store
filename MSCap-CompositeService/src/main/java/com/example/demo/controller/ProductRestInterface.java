package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Product;

@FeignClient(name="MS-ProductService")
public interface ProductRestInterface {
	
	@PostMapping("/product/addProduct")
	public Product fun1(@RequestBody Product product);
	
	@GetMapping("/product/getProduct/{id}")
	public Product fun2(@PathVariable int id);
	
	@DeleteMapping("/product/deleteCustomer/{id}")
	public void deleteProduct(@PathVariable int id);
	
	@GetMapping("/product/getAllCustomer")
	public List<Product> fun3();

}
