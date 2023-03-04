package com.fmv.ims.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.ims.models.UserShoppingBagMap;

public interface UserShoppingBagRepo extends JpaRepository<UserShoppingBagMap,Long> {


	List<UserShoppingBagMap> findByProfileId(Long id);

}
