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
@Table(name = "user_address_map")
public class UserAddressMap {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name="address")
	private Address address;
	

	@ManyToOne
	@JoinColumn(name="profile")
	private User profile;
	
}
