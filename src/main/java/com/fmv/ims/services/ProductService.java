package com.fmv.ims.services;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.iservice.IProductService;
import com.fmv.ims.models.Product;
import com.fmv.ims.repos.ProductRepo;
@Service
public class ProductService implements IProductService{
	@Autowired
	ProductRepo productRepo;
	Logger logger = Logger.getLogger(ProductService.class);
	
	public Product saveProduct(Product product) {
		Product productToSave = new Product();
		try {
			if (!(product.getId() == null)) {
				productToSave = productRepo.findById(product.getId()).get();
				productToSave.setName(product.getName());
				productToSave.setCreatedDate(new Date());
				productToSave.setDescription(product.getDescription());

				productToSave.setDiscount(product.getDiscount());
				productToSave.setFinalPrice(product.getFinalPrice());
				productToSave.setGst(product.getGst());
				productToSave.setProductImage(product.getProductImage());
				productToSave.setManufacture(product.getManufacture());
				productToSave.setSize(product.getSize());
				productToSave.setPrice(product.getPrice());
				productToSave.setStore(product.getStore());
				productToSave.setSubCategory(product.getSubCategory());
			}
			if (!(product.getId() == null)) {
				product = productRepo.save(productToSave);
			} else {
				productRepo.save(product);
			}

			return productToSave;
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Logger.Level.ERROR, e);
			return new Product();
		}
//		 product = productRepo.save(product);
//		return product;
	}
	public List<Product> findAllProduct(){
		return productRepo.findAll();
	}

}
