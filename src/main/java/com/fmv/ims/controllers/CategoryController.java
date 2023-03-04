package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Category;
import com.fmv.ims.services.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAllCategorys(){
		return categoryService.findAllCategory();
	}
	
	@PostMapping("/categories")
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}

}

