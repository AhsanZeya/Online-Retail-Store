package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.model.LineItem;
import com.example.demo.repository.LineRepository;
import com.example.demo.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	LineRepository lineRepository;
	
	
	@PostMapping("/addCart")
	public Cart fun1(@RequestBody Cart cart) {
		return cartService.insertCart(cart);
	}
	
	@GetMapping("/getCart/{id}")
	public Cart fun2(@PathVariable int id) {
		return cartService.getCart(id);
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public void deleteCart(@PathVariable int id) {
		cartService.deleteCart(id);
	}
	
	@GetMapping("/getAllCart")
	public List<Cart> fun3(){
		return cartService.getAllCart();
	}
	@GetMapping("/getAllItem/{id}")
	public List<LineItem> fun4(@PathVariable int id){
		return cartService.getAllItem(id);
	}
	@DeleteMapping("/deleteAllItem/{id}")
	public String alldelete(@PathVariable int id) {
		 //cartService.deleteAllCartItem(id);
		//lineRepository.deleteAll();
		List<LineItem> ll=fun4(id);
		System.out.println(ll.get(0).getProductName());
		for(int i=0;i<ll.size();i++) {
			lineRepository.delete(ll.get(i));
		}
		
		return "deleted";
	}
	@PutMapping("/updateCart/{id}")
	public void fun4(@PathVariable int id,@RequestBody Cart cart){
		cartService.updateCart(id, cart);
		//return new ResponseEntity<Object>("updated",HttpStatus.OK);
	}
	
	@PutMapping("/emptyCart/{id}")
	public String emptyCart(@PathVariable int id) {
		Cart emptycart=new Cart();
		cartService.updateCart(id, emptycart);
		return "Updated";
	}

}
