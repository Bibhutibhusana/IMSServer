package com.fmv.ims.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.Store;
import com.fmv.ims.repos.StoreRepo;

@Service
public class StoreService {
	@Autowired 
	StoreRepo storeRepo;
	
	public List<Store> getStores(){
		return storeRepo.findAll();
	}

	public Store getStoreById(@Valid Long id) {
		// TODO Auto-generated method stub
		Optional<Store> store =  storeRepo.findById(id);
		return store.get();
	}

	public Store saveStore(Store store) {
		// TODO Auto-generated method stub
		return storeRepo.save(store);
	}

}
