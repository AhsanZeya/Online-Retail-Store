package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LineItem;

@Repository
public interface LineRepository extends CrudRepository<LineItem,Integer>{

	
}
