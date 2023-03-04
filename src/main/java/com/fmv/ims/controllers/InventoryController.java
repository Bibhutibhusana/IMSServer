package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Inventory;
import com.fmv.ims.services.InventoryService;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/inventories")
	public List<Inventory> getAllInventorys(){
		return inventoryService.findAll();
	}
	
	@PostMapping("/inventories")
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		return inventoryService.save(inventory);
	}

}
