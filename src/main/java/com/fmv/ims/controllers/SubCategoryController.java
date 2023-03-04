package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.SubCategory;
import com.fmv.ims.services.SubCategoryService;

@RestController
@RequestMapping("/api/v1")
public class SubCategoryController {
	@Autowired
	SubCategoryService subCategoryService;
	
	@GetMapping("/subCategories")
	public List<SubCategory> getAllSubCategorys(){
		return subCategoryService.findAllSubCategory();
	}
	
	@PostMapping("/subCategories")
	public SubCategory saveSubCategory(@RequestBody SubCategory subCategory) {
		return subCategoryService.saveSubCategory(subCategory);
	}

}
