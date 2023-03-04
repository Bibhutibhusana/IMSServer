package com.fmv.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class SubCategory extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="sub_category")
	private String subCategory;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

}
