package com.fmv.ims.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.Unit;
import com.fmv.ims.repos.UnitRepo;

import io.jsonwebtoken.lang.Objects;

@Service
public class UnitService {
	@Autowired
	UnitRepo unitRepo;
	
	public Unit saveUnit(Unit unit) {
		Unit unitToSave = new Unit();
		try {
		if(!(unit.getId() ==  null)) {
			unitToSave = unitRepo.findById(unit.getId()).get();
			 unitToSave.setUnit(unit.getUnit());
			 unitToSave.setUnitType(unit.getUnitType());
		}
		if(!(unit.getId() ==  null)) {
			 unit = unitRepo.save(unitToSave);
		}else {
			unitRepo.save(unit);
		}
		
		return unitToSave;
		}
		catch(Exception e) {
			System.out.println(e);
			return new Unit();
		}
	}
	
	public List<Unit> fetchUnit() {
		List<Unit> unitRes = unitRepo.findAll();
		return unitRes;
	}

	public Optional<Unit> getUnitById(Long id) {
		
		return unitRepo.findById(id);
	}

}
