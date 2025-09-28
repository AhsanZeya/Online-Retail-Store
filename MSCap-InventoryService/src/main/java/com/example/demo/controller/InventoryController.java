package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Inventory;
import com.example.demo.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@PostMapping("/addInventory")
	public Inventory fun1(@RequestBody Inventory inventory) {
		return inventoryService.insertInventory(inventory);
	}
	
	@GetMapping("/getInventory/{id}")
	public Inventory fun2(@PathVariable int id) {
		return inventoryService.getInventory(id);
	}
	
	@DeleteMapping("/deleteInventory/{id}")
	public void deleteCart(@PathVariable int id) {
		inventoryService.deleteInventory(id);
	}
	
	@GetMapping("/getAllInventory")
	public List<Inventory> fun3(){
		return inventoryService.getAllInventory();
	}
	@PutMapping("/updateIncentory/{id}")
	public void updateInv(@PathVariable int id,@RequestBody Inventory inventory) {
		inventoryService.updateInventory(id,inventory);
		
	}
	@GetMapping("/fetchInventory/{id}")
	public Inventory fetchInventory(@PathVariable int id) {
		return inventoryService.getInventorybypid(id);
	}

}
