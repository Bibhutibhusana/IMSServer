package com.fmv.ims.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.Manufacturer;
import com.fmv.ims.repos.ManufactureRepo;

@Service
public class ManufacturerService {
	@Autowired
	ManufactureRepo manufacturerRepo;

	Logger logger = Logger.getLogger(ManufacturerService.class);

	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		Manufacturer manufactureToSave = new Manufacturer();
		try {
			if (!(manufacturer.getId() == null)) {
				manufactureToSave = manufacturerRepo.findById(manufacturer.getId()).get();
				manufactureToSave.setName(manufacturer.getName());
				manufactureToSave.setDescription(manufacturer.getDescription());
				manufactureToSave.setEstd(manufacturer.getEstd());
				manufactureToSave.setLocation(manufacturer.getLocation());
			}
			if (!(manufacturer.getId() == null)) {
				manufacturer = manufacturerRepo.save(manufactureToSave);
			} else {
				manufacturerRepo.save(manufacturer);
			}

			return manufactureToSave;
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Logger.Level.ERROR, e);
			return new Manufacturer();
		}
	}

	public List<Manufacturer> findAllManufacturer() {
		return manufacturerRepo.findAll();
	}

}