package com.fmv.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmv.ims.services.AuthService;
import com.fmv.ims.services.UserService;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user_shopping_map")
@NoArgsConstructor
public class UserShoppingBagMap {
	
	
	
	public  UserShoppingBagMap(Long id, ShoppingBag shoppingBag, Long profile){
		this.id = id;
		this.shoppingBag = shoppingBag;
		UserService userService = new UserService();
		System.out.println(profile);
		this.profile =  userService.getUserById(profile);
	
		
	}
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	 
	@ManyToOne 
	@JoinColumn(name="shopping_bag")
	private ShoppingBag shoppingBag;
	

	@ManyToOne
	@JoinColumn(name="profile")
	private User profile;
	
	
	

}
