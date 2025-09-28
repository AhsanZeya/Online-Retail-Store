package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Integer>{
  
	   public Inventory findInventoryByProductId(int productId);
}
