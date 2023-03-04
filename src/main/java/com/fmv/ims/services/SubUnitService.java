package com.fmv.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fmv.ims.models.SubUnit;
import com.fmv.ims.models.Unit;
import com.fmv.ims.repos.SubUnitRepo;

@Service
public class SubUnitService{
	@Autowired
	SubUnitRepo subUnitRepo;
	
	public SubUnit saveSubUnit(SubUnit subUnit) {
		SubUnit subUnitToSave = new SubUnit();
		try {
		if(subUnit.getId() != null) {
			subUnitToSave = subUnitRepo.findById(subUnit.getId()).get();
			subUnitToSave.setUnit(subUnit.getUnit());
			subUnitToSave.setSubUnit(subUnit.getSubUnit());
			subUnitToSave.setValue(subUnit.getValue());
		}
		if(subUnitToSave.getId() != null ) {
			subUnit = subUnitRepo.save(subUnitToSave);
		}
		else {
			subUnitRepo.save(subUnit);
		}
		
		return subUnitToSave;
		}
		catch(Exception e) {
			return new SubUnit();
		}
	}
	
	public List<SubUnit> findAllSubUnit(){
		return subUnitRepo.findAll();
	}
	
	public SubUnit findSubUnitById(Long id) {
		return subUnitRepo.findById(id).get();
	}

}
