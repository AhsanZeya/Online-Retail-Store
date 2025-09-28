package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomerNotAddedException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public Customer fun1(@RequestBody Customer customer) throws CustomerNotAddedException {
		if(customer.getCustomerName().equals(null)) {
			throw new CustomerNotAddedException("Customer is not added");
		}
		return customerService.insertCustomer(customer);
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer fun2(@PathVariable int id) throws CustomerNotFoundException {
		return customerService.getCustomer(id);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
		customerService.deleteCustomer(id);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> fun3(){
		return customerService.getAllCustomer();
	}

}
