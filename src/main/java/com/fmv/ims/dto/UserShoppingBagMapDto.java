package com.fmv.ims.dto;

import com.fmv.ims.models.ShoppingBag;
import com.fmv.ims.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShoppingBagMapDto {


		private Long id;

		private ShoppingBag shoppingBag;

		private User profile;


}
