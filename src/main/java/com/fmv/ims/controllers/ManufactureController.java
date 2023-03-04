package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Manufacturer;
import com.fmv.ims.services.ManufacturerService;

@RestController
@RequestMapping("/api/v1")
public class ManufactureController {
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping("/manufacturers")
	public List<Manufacturer> getAllManufacturers(){
		return manufacturerService.findAllManufacturer();
	}
	
	@PostMapping("/manufacturers")
	public Manufacturer saveManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.saveManufacturer(manufacturer);
	}

}
