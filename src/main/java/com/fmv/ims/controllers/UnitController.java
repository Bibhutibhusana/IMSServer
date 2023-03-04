package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Unit;
import com.fmv.ims.services.UnitService;

@RestController
@RequestMapping("/api/v1")
public class UnitController {
	@Autowired
	UnitService unitService;
	
	@GetMapping("/units")
	public List<Unit> getAllUnits(){
		return unitService.fetchUnit();
	}
	
	@PostMapping("/units")
	public Unit saveUnit(@RequestBody Unit unit) {
		
		return unitService.saveUnit(unit);
	}

}
