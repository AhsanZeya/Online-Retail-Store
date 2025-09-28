package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public Inventory insertInventory(Inventory inventory)
	{
		return inventoryRepository.save(inventory);
	}
	
	public Inventory getInventory(int id) {
		return inventoryRepository.findById(id).get();
	}
    public List<Inventory> getAllInventory() {
    	return (List<Inventory>) inventoryRepository.findAll();
    }
	public void deleteInventory(int id) {
		inventoryRepository.deleteById(id);
	}
	public void updateInventory(int id,Inventory inventory)
	{
		Inventory inv=inventoryRepository.findById(id).get();
		inv.setInventoryId(id);
		inv.setProductId(inventory.getProductId());
		inv.setQuantity(inventory.getQuantity());
		inventoryRepository.save(inv);
	}
	public Inventory getInventorybypid(int productId) {
		return inventoryRepository.findInventoryByProductId(productId);
	}
	

}
