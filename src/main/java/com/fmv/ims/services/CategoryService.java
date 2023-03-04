package com.fmv.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.Category;
import com.fmv.ims.repos.CategoryRepo;

@Service
public class CategoryService{
	@Autowired
	CategoryRepo categoryRepo;
	
	public Category saveCategory(Category category) {
		Category categoryToSave = new Category();
		try {
		if(!(category.getId() ==  null)) {
			categoryToSave = categoryRepo.findById(category.getId()).get();
			 categoryToSave.setCategory(category.getCategory());
			 categoryToSave.setDescription(category.getDescription());
		}
		if(!(category.getId() ==  null)) {
			 category = categoryRepo.save(categoryToSave);
		}else {
			categoryRepo.save(category);
		}
		
		return categoryToSave;
		}
		catch(Exception e) {
			System.out.println(e);
			return new Category();
		}
		 
	}
	public List<Category> findAllCategory(){
		return categoryRepo.findAll();
	}

}