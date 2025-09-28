package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerService;
import com.example.demo.dto.ProductService;
import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerCart;
import com.example.demo.model.CustomerOrder;
import com.example.demo.model.Inventory;
import com.example.demo.model.LineItem;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.CustomerCartRepository;
import com.example.demo.repository.CustomerOrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import com.example.demo.repository.InventoryRepository;

@RestController
public class CompositeController {
	
	int k=100;
	int y=1;
	
	@Autowired
	ProductRestInterface proInt;
	
	@Autowired
	InventoryRestInterface invenInt;
	
	@Autowired
	CutomerRestInterface custInt;
	
	@Autowired
	CartRestInterface cartInt;
	
	@Autowired
	CustomerCartRepository custcartRepo;
	
	@Autowired
	OrderRestInterface orderRepo;
	
	@Autowired
	CustomerOrderRepository cusordRepo;
	
	
	
	@PostMapping("shopping/product/add")
	@CircuitBreaker(name="productBreaker",fallbackMethod="fallBackProductBreaker")
	public ResponseEntity<Object> fun1(@RequestBody ProductService productservice){
		Product p1=new Product();
		p1.setProductId(productservice.getId());
		p1.setProductName(productservice.getProductName());
		p1.setProductDescription(productservice.getProductDescription());
		p1.setPrice(productservice.getPrice());
		int productid=proInt.fun1(p1).getProductId();
		Inventory i1=new Inventory();
		i1.setProductId(productid);
		i1.setQuantity(productservice.getQuantity());
		invenInt.fun1(i1);
		return new ResponseEntity<Object>("added",HttpStatus.CREATED);
	}
	
	public ResponseEntity<Object> fallBackProductBreaker(Exception ex){
		return new ResponseEntity<Object>("Product Service is down!!! Try again later",HttpStatus.OK);
		
	}
	
	@PostMapping("shopping/customer/add")
	@CircuitBreaker(name="customerBreaker",fallbackMethod="fallBackCustomerBreaker")
	public ResponseEntity<Object> fun2(@RequestBody CustomerService customerservice){
		Customer c1=new Customer();
		c1.setCustomerId(customerservice.getId());
		c1.setCustomerName(customerservice.getCustomerName());
		c1.setCustomerEmail(customerservice.getCustomerEmail());
		c1.setCustomerBillingAddress(customerservice.getCustomerBillingAddress());
		c1.setCustomerShippingAddress(customerservice.getCustomerShippingAddress());
		int customerId=custInt.fun1(c1).getCustomerId();
		Cart cart1=new Cart();
		cart1.setLineItem(new ArrayList<LineItem>());
		int cartId=cartInt.fun1(cart1).getCartId();
		CustomerCart cc1=new CustomerCart();
		cc1.setCustomerId(customerId);
		cc1.setCartId(cartId);
		custcartRepo.save(cc1);
		return new ResponseEntity<Object>("added",HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<Object> fallBackCustomerBreaker(Exception ex){
		return new ResponseEntity<Object>("Customer Service is down!!!Try again later",HttpStatus.OK);
	}
	@PutMapping("shopping/customer/{customerId}/cart")
	@CircuitBreaker(name="cartBreaker", fallbackMethod="fallbackCartBreaker")
	public ResponseEntity<Object> fun3(@PathVariable int customerId,@RequestBody Cart cart){
		CustomerCart c1=custcartRepo.findById(customerId).get();
		int cartId=c1.getCartId();
		cartInt.fun4(cartId, cart);
		return new ResponseEntity<Object>("updated",HttpStatus.OK);
	}
	
	public ResponseEntity<Object> fallbackCartBreaker(Exception ex){
		return new ResponseEntity<Object>("Cart Services is down!!!Try again later",HttpStatus.OK);
	}
	@PostMapping("shopping/customer/{customerId}/order")
	@CircuitBreaker(name="orderBreaker",fallbackMethod="fallbackOrderBreaker")
	public ResponseEntity<Object> fun4(@PathVariable int customerId){
		CustomerCart c1=custcartRepo.findById(customerId).get();
		int cartId=c1.getCartId();
		Cart c11=cartInt.fun2(cartId);
		int a=c11.getLineItem().size();
		//c11.getLineItem().clear();
		Order o1=new Order();
		o1.setOrderId(k);
		o1.setLineItem(c11.getLineItem());
		CustomerOrder co1=new CustomerOrder();
		co1.setId(y);
		co1.setCustomerId(customerId);
		co1.setOrderId(k);
		cusordRepo.save(co1);
		orderRepo.fun1(o1);
		List<LineItem> ordl=o1.getLineItem();
		for(int i=0;i<ordl.size();i++) {
			int p=ordl.get(i).getProductId();
			int q=ordl.get(i).getQuantity();
			Inventory inventory=invenInt.fetchInventory(ordl.get(i).getProductId());
			inventory.setProductId(p);
			inventory.setQuantity(inventory.getQuantity()-q);
			invenInt.updateInv(inventory.getInventoryId(), inventory);
			//invenInt.updateInv(ordl.get(i).getProductId(), inventory.getQuantity(),ordl.get(i).getQuantity());
		}
		cartInt.emptyCart(cartId);
		System.out.println(a);
		k=k+1;
		y=y+1;
		return new ResponseEntity<Object>("Order Place Successfully!!!",HttpStatus.OK);
		//return new ResponseEntity<Object>("number of items:"+a,HttpStatus.OK);
	}
	@GetMapping("shopping/customer/{customerId}/order")
	//@CircuitBreaker(name="orderBreaker",fallbackMethod="fallbackOrderBreaker")
	public List<Order> fun5(@PathVariable int customerId) {
		List<CustomerOrder> co1=cusordRepo.findCustomerOrderByCustomerId(customerId);
		List<Order> ordl=new ArrayList<Order>();
		List<Integer> oil=new ArrayList<Integer>();
		for(int i=0;i<co1.size();i++) {
			oil.add(co1.get(i).getOrderId());
		}
		for(int i=0;i<oil.size();i++) {
			ordl.add(orderRepo.fun2(oil.get(i)));
		}
		return ordl;
		
	}
	
	public ResponseEntity<Object> fallbackOrderBreaker(Exception ex){
		return new ResponseEntity<Object>("Order Service is down!!!Try again later",HttpStatus.OK);
	}
	@GetMapping("getCustomerOrder/{customerId}")
	public List<CustomerOrder> fun6(@PathVariable int customerId){
		return cusordRepo.findCustomerOrderByCustomerId(customerId);
	}

}
