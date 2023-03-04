package com.fmv.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.UserAddressMap;
import com.fmv.ims.repos.UserAddressMapRepo;

@Service
public class UserAddressMapService {
	@Autowired
	UserAddressMapRepo userAddressMapRepo;
	
	public UserAddressMap saveUserAddressMap(UserAddressMap userAddressMap) {
		UserAddressMap userAddressMapToSave = new UserAddressMap();
		try {
		if(!(userAddressMap.getId() ==  null)) {
			userAddressMapToSave = userAddressMapRepo.findById(userAddressMap.getId()).get();
			 userAddressMapToSave.setAddress(userAddressMap.getAddress());
			 userAddressMapToSave.setProfile(userAddressMap.getProfile());
		}
		if(!(userAddressMap.getId() ==  null)) {
			 userAddressMap = userAddressMapRepo.save(userAddressMapToSave);
		}else {
			userAddressMapRepo.save(userAddressMap);
		}
		
		return userAddressMapToSave;
		}
		catch(Exception e) {
			System.out.println(e);
			return new UserAddressMap();
		}
		 
	}
	public List<UserAddressMap> findAllUserAddressMap(){
		return userAddressMapRepo.findAll();
	}
}
