package com.fmv.ims.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.dto.UserShoppingBagMapDto;
import com.fmv.ims.models.UserShoppingBagMap;
import com.fmv.ims.repos.UserShoppingBagRepo;

@Service
public class UserShoppingBagService {

	@Autowired
	UserShoppingBagRepo userShoppingBagRepo;
	@Autowired
	ModelMapper modelMapper;
	Logger logger = Logger.getLogger(UserShoppingBagMap.class);

	public UserShoppingBagMap saveUserShoppingBag(UserShoppingBagMap userShoppingBag) {
		
		UserShoppingBagMap UserShoppingBagToSave = new UserShoppingBagMap();
		try {
			if (userShoppingBag.getId() != null) {
				UserShoppingBagToSave = userShoppingBagRepo.findById(userShoppingBag.getId()).get();
				UserShoppingBagToSave.setProfile(userShoppingBag.getProfile());
				UserShoppingBagToSave.setShoppingBag(userShoppingBag.getShoppingBag());
			}
			if (UserShoppingBagToSave.getId() != null) {
				userShoppingBag = userShoppingBagRepo.save(UserShoppingBagToSave);
			} else {
				userShoppingBag = userShoppingBagRepo.save(userShoppingBag);
			}

			return userShoppingBag;
		} catch (Exception e) {
			logger.log(Logger.Level.ERROR,e);
			return new UserShoppingBagMap();
		}

	}

	public List<UserShoppingBagMap> findAllUserShoppingBag() {
		return userShoppingBagRepo.findAll();
	}

	public List<UserShoppingBagMapDto> getUserShoppingBagByUserId(Long id) {
		// TODO Auto-generated method stub
		List<UserShoppingBagMapDto> userShoppingMapDto = new ArrayList<UserShoppingBagMapDto>();
		try {
			userShoppingMapDto = userShoppingBagRepo.findByProfileId(id).stream()
					.map(val -> modelMapper.map(val, UserShoppingBagMapDto.class)).collect(Collectors.toList());
		}
		catch(Exception e) {
			logger.log(Logger.Level.ERROR,"On Line 53" + e);
		}
		return userShoppingMapDto;
	}

}
