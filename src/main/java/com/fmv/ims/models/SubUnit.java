package com.fmv.ims.models;

import java.io.Serializable;

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
public class SubUnit extends BaseEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name="unit_id")
	private Unit unit = new Unit();
	
	@Column(name="sub_unit")
	private String subUnit;
	
	@Column(name="value")
	private String value;
	
}
