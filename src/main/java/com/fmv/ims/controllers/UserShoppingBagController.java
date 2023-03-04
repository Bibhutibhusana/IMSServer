package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.dto.UserShoppingBagMapDto;
import com.fmv.ims.models.UserShoppingBagMap;
import com.fmv.ims.services.UserShoppingBagService;

@RestController
@RequestMapping("/api/v1")
public class UserShoppingBagController {
	@Autowired
	UserShoppingBagService userShoppingBagService;

	@GetMapping("/userShoppingBags")
	public List<UserShoppingBagMap> getAllProducts() {
		return userShoppingBagService.findAllUserShoppingBag();
	}
	@GetMapping("/userShoppingBags/byUserId/{id}")	
	private List<UserShoppingBagMapDto> getUserShoppingBagByUserId(@PathVariable(value="id") Long id) {
		return userShoppingBagService.getUserShoppingBagByUserId(id);
	}

	@PostMapping("/userShoppingBags")
	public UserShoppingBagMap saveProduct(@RequestBody UserShoppingBagMap product) {
		return userShoppingBagService.saveUserShoppingBag(product);
	}
}
