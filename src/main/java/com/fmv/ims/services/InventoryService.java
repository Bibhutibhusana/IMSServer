package com.fmv.ims.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.iservice.IInventoryService;
import com.fmv.ims.models.Inventory;
import com.fmv.ims.models.Inventory;
import com.fmv.ims.repos.InventoryRepo;

@Service
public class InventoryService implements IInventoryService{
	@Autowired
	InventoryRepo inventoryRepo;
	Logger logger = Logger.getLogger(InventoryService.class);
	
	public Inventory save(Inventory inventory) {
		Inventory inventoryToSave = new Inventory();
		try {
			if (!(inventory.getId() == null)) {
				inventoryToSave = inventoryRepo.findById(inventory.getId()).get();
				inventoryToSave.setProduct(inventory.getProduct());
				inventoryToSave.setStock(inventory.getStock());
			}
			if (!(inventory.getId() == null)) {
				inventory = inventoryRepo.save(inventoryToSave);
			} else {
				inventoryRepo.save(inventory);
			}

			return inventoryToSave;
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Logger.Level.ERROR, e);
			return new Inventory();
		}
//		return inventoryRepo.save(inventory);
	}
	
	public List<Inventory> findAll(){
		return inventoryRepo.findAll();
	}

}
