package com.fmv.ims.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_product_map")
public class OrderProductMap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order = new Order();

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product = new Product();

}
