package com.fmv.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmv.ims.models.Order;
import com.fmv.ims.services.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderService.findAll();
	}
	
	@PostMapping("/orders")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.save(order);
	}

}
