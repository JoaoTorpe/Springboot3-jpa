package com.educaweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.entities.Product;
import com.educaweb.curso.repositories.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository Repository;
	
	public List<Product> findAll(){
		
		return Repository.findAll();
		
	}
	
	
	public Product findById(Long id) {
		
		Optional<Product> Product =  Repository.findById(id);
		
		return Product.get();
	}
	
	
	
}
