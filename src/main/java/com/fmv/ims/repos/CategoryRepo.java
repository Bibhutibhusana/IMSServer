package com.fmv.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.ims.models.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{

}
