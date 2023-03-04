package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.SubUnit;
import com.fmv.ims.services.SubUnitService;

@RestController
@RequestMapping("/api/v1")
public class SubUnitController {
	@Autowired
	SubUnitService subUnitService;
	
	@GetMapping("/subUnits")
	public List<SubUnit> getAllSubUnits(){
		return subUnitService.findAllSubUnit();
	}
	
	@PostMapping("/subUnits")
	public SubUnit saveSubUnit(@RequestBody SubUnit subUnit) {
		return subUnitService.saveSubUnit(subUnit);
	}

}