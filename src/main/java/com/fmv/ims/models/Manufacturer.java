package com.fmv.ims.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="manufacturer")
public class Manufacturer extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(max=30)
	@Column(name="name",length=30)
	private String name;
	
	@Size(max=100)
	@Column(name="description",length=100)
	private String description;
	

	@Column(name="estd")
	private Date estd;
	
	@Column(name="location")
	private String location;

}
