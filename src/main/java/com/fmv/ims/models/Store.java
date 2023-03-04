package com.fmv.ims.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String location;
	
}
