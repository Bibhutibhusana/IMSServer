package com.fmv.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmv.ims.models.UserAddressMap;

@Repository
public interface UserAddressMapRepo extends JpaRepository<UserAddressMap,Long>{

}
