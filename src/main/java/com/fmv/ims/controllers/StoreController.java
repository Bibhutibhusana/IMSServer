package com.fmv.ims.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Store;
import com.fmv.ims.services.StoreService;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin
public class StoreController {
	@Autowired
	StoreService storeService;
	
	@GetMapping("/stores")
	private List<Store> getStores(){
		return storeService.getStores();
	}
	
	@GetMapping("/stores/{id}")
	private Store getStoreById(@Valid @PathVariable(value="id")Long id) {
		return storeService.getStoreById(id);
	}
	@PostMapping("/stores")
	private Store saveStore(@RequestBody Store store) {
		return storeService.saveStore(store);
	}

}
 