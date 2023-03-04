package com.fmv.ims.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_order")
@Data
public class Order extends BaseEntity {
	@Id
	@Column(name = "id")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "products")
	// @NotAudited @IndexColumn(name="LIST_INDEX", nullable=false, base=1)
	List<OrderProductMap> products = new ArrayList<OrderProductMap>();

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

	@Column(name = "status")
	private String status;

}
