package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductNotFound;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;




@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product insertProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Product getProduct(int id) throws ProductNotFound {
		Optional<Product> p1=productRepository.findById(id);
		if(p1.isPresent()) {
			return productRepository.findById(id).get();
		}
		else {
			throw new ProductNotFound("Product is not found");
		}
		
	}
    public List<Product> getAllProduct() {
    	return (List<Product>) productRepository.findAll();
    }
	public void deleteProduct(int id) throws ProductNotFound {
		Optional<Product> p1=productRepository.findById(id);
		if(p1.isPresent()) {
		      productRepository.deleteById(id);
		}
		else {
			throw new ProductNotFound("Product is not found");
		}
	}
}
