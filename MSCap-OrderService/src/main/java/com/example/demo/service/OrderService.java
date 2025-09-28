package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	public Order insertOrder(Order order)
	{
		return orderRepo.save(order);
	}
	
	public Order getOrder(int id) throws OrderNotFoundException {
		Optional<Order> o1=orderRepo.findById(id);
		if(o1.isPresent()) {
			return orderRepo.findById(id).get();
		}
		else {
			throw new OrderNotFoundException("Order is not found");
		}
	}
    public List<Order> getAllOrder() {
    	return (List<Order>) orderRepo.findAll();
    }
	public void deleteOrder(int id) throws OrderNotFoundException {
		Optional<Order> o1=orderRepo.findById(id);
		if(o1.isPresent()) {
			orderRepo.deleteById(id);
		}
		else {
			throw new OrderNotFoundException("Order is not found");
		}
	    
	}
	

}
