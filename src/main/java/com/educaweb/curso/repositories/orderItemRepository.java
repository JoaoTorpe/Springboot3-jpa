package com.educaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaweb.curso.entities.OrderItem;

public interface orderItemRepository extends JpaRepository<OrderItem, Long>{
	
	

}
