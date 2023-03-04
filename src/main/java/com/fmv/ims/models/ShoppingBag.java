package com.fmv.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shopping_bag")
@Data
public class ShoppingBag {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="product")
	private Product product;
	
	@Column(name="quantity")
	private int quantity = 1 ;
	
	

}
 