package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Inventory;

@FeignClient(name="MS-InventoryService")
public interface InventoryRestInterface {
	
	@PostMapping("/addInventory")
	public Inventory fun1(@RequestBody Inventory inventory);
	
	@GetMapping("/getInventory/{id}")
	public Inventory fun2(@PathVariable int id);
	
	@DeleteMapping("/deleteInventory/{id}")
	public void deleteCart(@PathVariable int id);
	
	@GetMapping("/getAllInventory")
	public List<Inventory> fun3();
	
	@PutMapping("/updateIncentory/{id}")
	public void updateInv(@PathVariable int id,@RequestBody Inventory inventory);
	
	@GetMapping("/fetchInventory/{id}")
	public Inventory fetchInventory(@PathVariable int id);

}
