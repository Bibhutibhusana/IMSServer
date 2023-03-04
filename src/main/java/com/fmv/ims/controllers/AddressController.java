package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Address;
import com.fmv.ims.services.AddressService;

@RequestMapping("/api/v1")
@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@GetMapping("/addresses")
	public List<Address> getAllAddresss(){
		return addressService.findAllAddress();
	}
	
	@PostMapping("/addresses")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
}
