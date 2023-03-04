package com.fmv.ims.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.User;
import com.fmv.ims.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

}
