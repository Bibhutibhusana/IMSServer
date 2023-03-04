package com.fmv.ims.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmv.ims.models.Order;
import com.fmv.ims.repos.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;
	Logger logger = Logger.getLogger(OrderService.class);
	
	public Order save(Order order) {
		Order orderToSave = new Order();
		try {
			if (!(order.getId() == null)) {
				orderToSave = orderRepo.findById(order.getId()).get();
				orderToSave.setProducts(order.getProducts());
				orderToSave.setPrice(order.getPrice());
			}
			if (!(order.getId() == null)) {
				order = orderRepo.save(orderToSave);
			} else {
				orderRepo.save(order);
			}

			return orderToSave;
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Logger.Level.ERROR, e);
			return new Order();
		}
//		return orderRepo.save(order);
	}
	
	public List<Order> findAll(){
		return orderRepo.findAll();
	}


}
