package com.fmv.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@NumberFormat
	@Column(name="phone_no")
	private String phone_no;
	
	@Column(name="address")
	private String address;
	
	@Column(name="landmark")
	private String landmark;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pincode")
	private String pincode	;
	

}
