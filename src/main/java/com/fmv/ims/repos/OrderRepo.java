package com.fmv.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.ims.models.Order;

public interface OrderRepo extends JpaRepository<Order,Long> {

}
