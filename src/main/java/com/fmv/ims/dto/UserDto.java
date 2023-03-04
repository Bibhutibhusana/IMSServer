package com.fmv.ims.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;

import com.fmv.ims.models.Role;

import lombok.Data;

@Data
public class UserDto {
	 private Long id;
	  private String username;
	  @Email
	  private String email;
	  private Set<Role> roles = new HashSet<>();

}
