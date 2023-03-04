package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Product;
import com.fmv.ims.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.findAllProduct();
	}
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

}
