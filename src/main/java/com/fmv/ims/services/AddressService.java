package com.fmv.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.Address;
import com.fmv.ims.repos.AddressRepo;

@Service
public class AddressService {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		Address addressToSave = new Address();
		try {
		if(!(address.getId() ==  null)) {
			addressToSave = addressRepo.findById(address.getId()).get();
			addressToSave.setCountry(address.getCountry());
			 addressToSave.setAddress(address.getAddress());
			 addressToSave.setDistrict(address.getDistrict());
			 addressToSave.setFirstName(address.getFirstName());
			 addressToSave.setLandmark(address.getLandmark());
			 addressToSave.setLastName(address.getLastName());
			 addressToSave.setPhone_no(address.getPhone_no());
			 addressToSave.setPincode(address.getPhone_no());
			 addressToSave.setState(address.getState());
		}
		if(!(address.getId() ==  null)) {
			 address = addressRepo.save(addressToSave);
		}else {
			addressRepo.save(address);
		}
		
		return addressToSave;
		}
		catch(Exception e) {
			System.out.println(e);
			return new Address();
		}
		 
	}
	public List<Address> findAllAddress(){
		return addressRepo.findAll();
	}

}
