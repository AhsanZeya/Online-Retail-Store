package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LineRepository;
import com.example.demo.model.*;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	LineService lineService;
	
	public Cart insertCart(Cart cart)
	{
		return cartRepository.save(cart);
	}
	
	public Cart getCart(int id) {
		return cartRepository.findById(id).get();
	}
    public List<Cart> getAllCart() {
    	return (List<Cart>) cartRepository.findAll();
    }
	public void deleteCart(int id) {
	    cartRepository.deleteById(id);
	}
	public List<LineItem> getAllItem(int id){
		Cart c1=cartRepository.findById(id).get();
		System.out.println("ds");
		return c1.getLineItem();
	}
	public void deleteAllCartItem(int cartId) {
		List<LineItem> li1=this.getAllItem(cartId);
		List<Integer> iIdl=new ArrayList<Integer>();
		for(int i=0;i<li1.size();i++) {
			iIdl.add(li1.get(i).getItemId());
		}
		System.out.println(iIdl);
		
		/*for(int i=0;i<iIdl.size();i++) {
			//System.out.println("ds");
			//lineRepository.deleteById(iIdl.get(i));
			lineService.deleteItem(iIdl.get(i));
			
		}*/
	}
	public void updateCart(int id,Cart cart) {
		Cart c1=new Cart();
		c1.setCartId(id);
		c1.setLineItem(cart.getLineItem());
		cartRepository.save(c1);
	}
}
