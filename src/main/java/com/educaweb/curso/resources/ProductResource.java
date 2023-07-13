package com.educaweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaweb.curso.entities.Product;
import com.educaweb.curso.services.ProductService;

@RestController
@RequestMapping (value = "/products")
public class ProductResource {
	@Autowired
	private ProductService service;
	//Return all Products
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();		
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//get Product by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		return  ResponseEntity.ok().body(service.findById(id)) ;
		
	}
	

}