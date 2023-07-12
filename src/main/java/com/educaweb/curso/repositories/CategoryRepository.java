package com.educaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaweb.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	

}
