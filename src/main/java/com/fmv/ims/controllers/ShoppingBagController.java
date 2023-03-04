package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.ShoppingBag;
import com.fmv.ims.services.ShoppingBagService;


@RestController
@RequestMapping("/api/v1")
public class ShoppingBagController {
	@Autowired
	ShoppingBagService shoppingBagService;
	
	@GetMapping("/shoppingBags")
	public List<ShoppingBag> getAllProducts(){
		return shoppingBagService.findAllShoppingBag();
	}
	
	@PostMapping("/shoppingBags")
	public ShoppingBag saveProduct(@RequestBody ShoppingBag bag) {
		return shoppingBagService.saveShoppingBag(bag);
	}
}
