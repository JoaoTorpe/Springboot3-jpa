package com.educaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaweb.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
