package com.educaweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.entities.Order;
import com.educaweb.curso.repositories.orderRepository;

@Service
public class orderService {

	
	@Autowired
	private orderRepository Repository;
	
	public List<Order> findAll(){
		
		return Repository.findAll();
		
	}
	
	
	public Order findById(Long id) {
		
		Optional<Order> order =  Repository.findById(id);
		
		return order.get();
	}
	
	
	
}
