package com.fmv.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.ims.models.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

}
