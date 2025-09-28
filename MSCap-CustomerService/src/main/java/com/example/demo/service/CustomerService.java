package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer insertCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public Customer getCustomer(int id) throws CustomerNotFoundException {
		Optional<Customer> c1=customerRepository.findById(id);
		if(c1.isPresent()) {
			return customerRepository.findById(id).get();
		}
		else {
			throw new CustomerNotFoundException("Customer is not found");
		}
		
	}
    public List<Customer> getAllCustomer() {
    	return (List<Customer>) customerRepository.findAll();
    }
	public void deleteCustomer(int id) throws CustomerNotFoundException {
		Optional<Customer> c1=customerRepository.findById(id);
		if(c1.isPresent()) {
		      customerRepository.deleteById(id);
		}
		else {
			throw new CustomerNotFoundException("Customer is not found");
		}
	}
}
