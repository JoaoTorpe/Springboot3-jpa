package com.educaweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaweb.curso.entities.Order;
import com.educaweb.curso.services.orderService;

@RestController
@RequestMapping (value = "/orders")
public class orderResource {
	@Autowired
	private orderService service;
	//Return all orders
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();		
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//get order by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		return  ResponseEntity.ok().body(service.findById(id)) ;
		
	}
	

}