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

import com.example.demo.exception.ProductNotAdded;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.model.*;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public Product fun1(@RequestBody Product product) throws ProductNotAdded {
		if(product.getProductName().equals(null)) {
			throw new ProductNotAdded("Product Data Not Properly Added");
		}
		return productService.insertProduct(product);
	}
	
	@GetMapping("/getProduct/{id}")
	public Product fun2(@PathVariable int id) throws ProductNotFound {
		return productService.getProduct(id);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteProduct(@PathVariable int id) throws ProductNotFound {
		productService.deleteProduct(id);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Product> fun3(){
		return productService.getAllProduct();
	}


}
