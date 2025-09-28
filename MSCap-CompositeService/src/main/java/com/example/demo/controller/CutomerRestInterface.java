package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Customer;

@FeignClient(name="MS-CustomerService")
public interface CutomerRestInterface {
	
	@PostMapping("/customer/addCustomer")
	public Customer fun1(@RequestBody Customer customer);
	
	@GetMapping("/customer/getCustomer/{id}")
	public Customer fun2(@PathVariable int id);
	
	@DeleteMapping("/customer/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable int id);
	
	@GetMapping("/customer/getAllCustomer")
	public List<Customer> fun3();

}
