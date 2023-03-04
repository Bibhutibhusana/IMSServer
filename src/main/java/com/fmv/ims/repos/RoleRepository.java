package com.fmv.ims.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.ims.models.ERole;
import com.fmv.ims.models.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	Optional<Role> findByName(ERole name);
	

}
