package com.fmv.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmv.ims.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long>{

}
