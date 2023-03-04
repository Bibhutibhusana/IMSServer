package com.fmv.ims.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class Product extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Size(max=50)
	@Column(name="name",length=50)
	private String name;
	
	@Size(max=300)
	@Column(name="description",length=300)
	private String description;
	
	@Column(name="product_image")
	private String productImage;
	
	
	@ManyToOne
	@JoinColumn(name="manufact_id")
	private Manufacturer manufacture = new Manufacturer();

	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store = new Store();
	
//	@ManyToOne
//	@JoinColumn(name="size")
//	private Unit size = new Unit();
	@ManyToOne
	@JoinColumn(name="size")
	private SubUnit size;
	
	@ManyToOne
	@JoinColumn(name="sub_category_id")
	private SubCategory subCategory;
	
	@Size(max=10)
	@Column(name="price")
	private Double price;
	
	@Size(max=2)
	@Column(name="discount")
	private Double discount;
	
	@Size(max=2)
	@Column(name="gst")
	private Double gst;
	
	@Size(max=10)
	@Column(name="f_price")
	private Double finalPrice;
	

}
