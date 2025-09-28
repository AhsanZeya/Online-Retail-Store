package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LineItem;
import com.example.demo.repository.LineRepository;

@Service
public class LineService {
	
	@Autowired
	LineRepository lineRepository;
	
	public LineItem insertItem(LineItem lineItem) {
		return lineRepository.save(lineItem);
	}
	public LineItem getItem(int id) {
		return lineRepository.findById(id).get();
	}
	public List<LineItem> getAllItem(){
		return (List<LineItem>) lineRepository.findAll();
	}
	public void deleteItem(int id) {
		lineRepository.deleteById(id);
	}

}
