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
public class Inventory extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="product")
	private Product product;
	
	@Column(name="stock")
	private int stock;

}
