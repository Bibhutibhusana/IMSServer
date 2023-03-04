package com.fmv.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.ims.models.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {

}
