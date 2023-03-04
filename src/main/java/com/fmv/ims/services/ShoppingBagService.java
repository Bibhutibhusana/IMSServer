package com.fmv.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.ShoppingBag;
import com.fmv.ims.repos.ShoppingBagRepo;

@Service
public class ShoppingBagService {
	@Autowired
	ShoppingBagRepo shoppingBagRepo;
	
	public ShoppingBag saveShoppingBag(ShoppingBag shoppingBag) {
		ShoppingBag shoppingBagToSave = new ShoppingBag();
		try {
		if(shoppingBag.getId() != null) {
			shoppingBagToSave = shoppingBagRepo.findById(shoppingBag.getId()).get();
			shoppingBagToSave.setProduct(shoppingBag.getProduct());
			shoppingBagToSave.setQuantity(shoppingBag.getQuantity());
		}
		if(shoppingBagToSave.getId() != null ) {
			shoppingBag = shoppingBagRepo.save(shoppingBagToSave);
		}
		else {
			shoppingBagToSave = shoppingBagRepo.save(shoppingBag);
		}
		
		return shoppingBagToSave;
		}
		catch(Exception e) {
			return new ShoppingBag();
		}
		
	}
	public List<ShoppingBag> findAllShoppingBag(){
		return shoppingBagRepo.findAll();
	}


}
