package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.UserAddressMap;
import com.fmv.ims.services.UserAddressMapService;

@RestController
@RequestMapping("/api/v1")
public class UserAddressMapController {
	@Autowired
	UserAddressMapService userAddressMapService;
	
	@GetMapping("/userAddressMaps")
	public List<UserAddressMap> getAllUserAddressMaps(){
		return userAddressMapService.findAllUserAddressMap();
	}
	
	@PostMapping("/userAddressMaps")
	public UserAddressMap saveUserAddressMap(@RequestBody UserAddressMap userAddressMap) {
		return userAddressMapService.saveUserAddressMap(userAddressMap);
	}

}
