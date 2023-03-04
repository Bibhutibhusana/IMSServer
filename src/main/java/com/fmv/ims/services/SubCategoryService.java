package com.fmv.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.SubCategory;
import com.fmv.ims.repos.SubCategoryRepo;

@Service
public class SubCategoryService{
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	public SubCategory saveSubCategory(SubCategory subCategory) {
		SubCategory subCategoryToSave = new SubCategory();
		try {
		if(subCategory.getId() != null) {
			subCategoryToSave = subCategoryRepo.findById(subCategory.getId()).get();
			subCategoryToSave.setCategory(subCategory.getCategory());
			subCategoryToSave.setSubCategory(subCategory.getSubCategory());
		}
		if(subCategoryToSave.getId() != null ) {
			subCategory = subCategoryRepo.save(subCategoryToSave);
		}
		else {
			subCategoryRepo.save(subCategory);
		}
		
		return subCategoryToSave;
		}
		catch(Exception e) {
			return new SubCategory();
		}
		
	}
	public List<SubCategory> findAllSubCategory(){
		return subCategoryRepo.findAll();
	}

}